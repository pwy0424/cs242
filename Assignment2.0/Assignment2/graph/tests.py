'''
Created on 02/26/2014

@author: Weiyang
'''

import unittest
import graph

class Test(unittest.TestCase):


    def testConstruction(self):
        cityList = [{"code" : "SCL" ,
            "name" : "Santiago" ,
            "country" : "CL" ,
            "continent" : "South America" ,
            "timezone" : -4 ,
            "coordinates" : {"S" : 33, "W" : 71} ,
            "population" : 6000000 ,
            "region" : 1}]
        routeList = [{"ports" : ["SCL" , "LIM"] ,
            "distance" : 2453}]
        g = graph.Graph(cityList, routeList)
        g.getGraph()
        self.assertEqual(g.cityList[0]["LIM"].pop(), 2453)
        
    def testGetLongest(self):
        cityList = [{"code" : "SCL" ,
            "name" : "Santiago" ,
            "country" : "CL" ,
            "continent" : "South America" ,
            "timezone" : -4 ,
            "coordinates" : {"S" : 33, "W" : 71} ,
            "population" : 6000000 ,
            "region" : 1}]
        routeList = [{"ports" : ["SCL" , "LIM"] ,
            "distance" : 2453}]
        g = graph.Graph(cityList, routeList)
        g.getGraph()
        self.assertEqual(g.findLongestFlight()["distance"], 2453)
        
    def testAverageFlight(self):
        cityList = [{"code" : "SCL" ,
            "name" : "Santiago" ,
            "country" : "CL" ,
            "continent" : "South America" ,
            "timezone" : -4 ,
            "coordinates" : {"S" : 33, "W" : 71} ,
            "population" : 6000000 ,
            "region" : 1}]
        routeList = [{"ports" : ["SCL" , "LIM"] ,
            "distance" : 2453}]
        g = graph.Graph(cityList, routeList)
        g.getGraph()
        self.assertEqual(g.findAverageDistance(), 2453)
        
    def testAverageSize(self):
        cityList = [{"code" : "SCL" ,
            "name" : "Santiago" ,
            "country" : "CL" ,
            "continent" : "South America" ,
            "timezone" : -4 ,
            "coordinates" : {"S" : 33, "W" : 71} ,
            "population" : 6000000 ,
            "region" : 1}]
        routeList = [{"ports" : ["SCL" , "LIM"] ,
            "distance" : 2453}]
        g = graph.Graph(cityList, routeList)
        g.getGraph()
        self.assertEqual(g.findAverageCitySize(), 6000000)
        
    def testBiggestCity(self):
        cityList = [{"code" : "SCL" ,
            "name" : "Santiago" ,
            "country" : "CL" ,
            "continent" : "South America" ,
            "timezone" : -4 ,
            "coordinates" : {"S" : 33, "W" : 71} ,
            "population" : 6000000 ,
            "region" : 1}]
        routeList = [{"ports" : ["SCL" , "LIM"] ,
            "distance" : 2453}]
        g = graph.Graph(cityList, routeList)
        g.getGraph()
        self.assertEqual(g.findBiggestCity()["population"], 6000000)

if __name__ == "__main__":
    unittest.main()
