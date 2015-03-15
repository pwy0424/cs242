'''
Created on 02/26/2014

@author: Weiyang
'''

import json
import urllib2
import graph
import graphUtility

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
    gU = graphUtility.GraphUtility();
    # text-based user interface
    action = "z"
    while(action not in ("q")):
        action = "z"
        while(action not in("a", "b", "c", "d", "e", "f", "g", "h", "i", "j","k","l","m", "q")):
            print("Welcome to CSAirline, the following functions are:")
            print("a. find city by entering the city name")
            print("b. find the longest flight")
            print("c. find the shortest flight")
            print("d. find average flight length")
            print("e. find the biggest city")
            print("f. find the smallest city")
            print("g. find average city size")
            print("h. show the list of continents and cities")
            print("i. find the hub cities")
            print("j. visualization url")
            print("k. edit the graph")
            print("l. save json file to disk")
            print("m. add Champaign from url")
            print("q. exit")
            action = raw_input("please enter the action you choose:\n")
            action = action.strip();
            print (action, type(action))
        
        if(action == "a"):
            city = raw_input("please enter the city name\n");
            print(gU.getInfoOfCity(g,city));
            
        if(action == "b"):
            print(gU.findLongestFlight(g));

        if(action == "c"):
            print(gU.findShortestFlight(g));

        if(action == "d"):
            print(gU.findAverageDistance(g));

        if(action == "e"):
            print(gU.findBiggestCity(g)["name"]);

        if(action == "f"):
            print(gU.findSmallestCity(g)["name"]);

        if(action == "g"):
            print(gU.findAverageCitySize(g));

        if(action == "h"):
            result = gU.findServingContinentAndCity(g);
            for key in result:
                print(key, "contains\n", result[key])

        if(action == "i"):
            for cities in gU.findHubCities(g):
                print(cities["name"]);

        # print out the url 
        if(action == "j"):
            visualize(g)
        
        if(action == "k"):
            choice = "start";
            while(choice not in ("a", "b", "c", "d","e")):
                print("a. add a city")
                print("b. add a route")
                print("c. remove a city")
                print("d. remove a route")
                print("e. edit a city")
                
                choice = raw_input("please enter your choice:\n");
                if(choice == "a"):
                    g.addCity();
                if(choice == "b"):
                    g.addRoute();
                if(choice == "c"):
                    g.removeCity(raw_input("enter the code of the city you want to remove:\n"));
                if(choice == "d"):
                    g.removeRoute(raw_input("port1(code): "), raw_input("port2(code): "),True);
                if(choice == "e"):
                    g.editingCity();
                    
        if(action == "l"):
            g.SaveGraphToDisk(raw_input("please enter file name:\n"));

        if(action == "m"):
            url2 = "https://wiki.engr.illinois.edu/download/attachments/232785827/cmi_hub.json?version=1&modificationDate=1390319035000";
            g.addGraph(url2);
        
        if(action not in ("q")):
            raw_input("press enter to continue")
    print("bye")


     
