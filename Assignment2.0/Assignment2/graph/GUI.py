'''
Created on 02/26/2014

@author: Weiyang
'''

import json
import urllib2
import graph
def visualize(g):
    result = "http://www.gcmap.com/mapui?P=";
    for flight in g.routeList:
        airport = flight["ports"];
        result = result + airport[0] + "-" + airport[1];
        result = result + ",+";
    print(result[0: len(result)-2])

if __name__ == '__main__':

    url="https://wiki.engr.illinois.edu/download/attachments/232785826/map_data.json?version=1&modificationDate=1390319034000"
    myData = urllib2.urlopen(url)
    csAirData = json.load(myData)
    

    
    # start to parsing csAirData 
    routes = csAirData["routes"];
    cities = csAirData["metros"];
    
    # import in graph g 
    g = graph.Graph(cities, routes);
    g.getGraph()
    # text-based user interface
    action = "k"
    while(action not in ("q")):
        action = "k"
        while(action not in("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "q")):
            print("Welcome to CSAirline, the following functions are:")
            print("a. find city by entering the city name")
            print("b. find the longest flight")
            print("c. find the shortest flight")
            print("d. find average flight length")
            print("e. find the biggest city")
            print("f. find the smallest city")
            print("g. find average city size")
            print("h. show the list of continents and cities")
            print("i. find the hub city")
            print("j. visualization url")
            print("q. exit")
            action = raw_input("please enter the action you choose:\n")
            action = action.strip();
            print (action, type(action))
        
        if(action == "a"):
            city = raw_input("please enter the city name\n");
            print(g.getInfoOfCity(city));
            
        if(action == "b"):
            print(g.findLongestFlight());

        if(action == "c"):
            print(g.findShortestFlight());

        if(action == "d"):
            print(g.findAverageDistance());

        if(action == "e"):
            print(g.findBiggestCity()["name"]);

        if(action == "f"):
            print(g.findSmallestCity()["name"]);

        if(action == "g"):
            print(g.findAverageCitySize());

        if(action == "h"):
            result = g.findServingContinentAndCity();
            for key in result:
                print(key, "contains\n", result[key])

        if(action == "i"):
            print(g.findHubCity()["name"]);

        # print out the url 
        if(action == "j"):
            visualize(g)
                
        
        if(action not in ("q")):
            raw_input("press enter to continue")
    print("bye")


     
