'''
Created on 02/26/2014

@author: Weiyang
'''

import unittest
import graph
import graphUtility

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
        self.assertEqual(g.cityList[0]["name"], "Santiago")
        
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
        gU = graphUtility.GraphUtility();
        g.getGraph()
        self.assertEqual(gU.findLongestFlight(g)["distance"], 2453)
        
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
        gU = graphUtility.GraphUtility();
        g.getGraph()
        self.assertEqual(gU.findAverageDistance(g), 2453)
        
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
        gU = graphUtility.GraphUtility();
        g.getGraph()
        self.assertEqual(gU.findAverageCitySize(g), 6000000)
        
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
        gU = graphUtility.GraphUtility();
        g.getGraph()
        self.assertEqual(gU.findBiggestCity(g)["population"], 6000000)
        
    def testTotalDistance(self):
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
        self.assertEqual(g.totalDistanceOfRoute(routeList), 2453)
        
    def testCost(self):
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
        self.assertEqual(g.costOfRoute(routeList), 2453*0.35)
        
    def testTime(self):
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
        self.assertEqual(g.timeOfRoute(routeList), 2453/800.0)

if __name__ == "__main__":
    unittest.main()
