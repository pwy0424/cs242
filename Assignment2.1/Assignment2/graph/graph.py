'''
Created on 02/26/2014

@author: Weiyang
'''
import json
import urllib2
import copy;

class Graph:

    # getting the graph from JSON.
    def __init__(self, city, route):
        self.cityList = city;
        self.routeList = route;
        for c in self.cityList:
            c["neighbor"] = {};

    
    # parse the graph 
    def getGraph(self):
        for route in self.routeList:
            tempPortList = route["ports"];
            tempDistance = route["distance"]
        
            for city in self.cityList:    
                if(city["code"] == tempPortList[0]):
                    city["neighbor"][tempPortList[1]] = {tempDistance}
                elif(city["code"] == tempPortList[1]):
                    city["neighbor"][tempPortList[0]] = {tempDistance}


    # editing the graph
    
    # remove a city by inputing the code of the city
    def removeCity(self, cityCode):
        
        deletedCity = [];
        
        index = 0;
        for city in self.cityList:
            if(cityCode == city["code"]):
                deletedCity.append(city["code"]);
                deletedCity.append(city["name"]);
                del self.cityList[index];
                break
            index = index + 1;
        
        if(deletedCity == []):
            print "city is not found";
            return None;
        
        for city in self.cityList:
            self.removeRoute(cityCode, city["code"], False);
        
        print "the city " + deletedCity[1] + " with code " + deletedCity[0] + " has deleted!";

    
    def removeRoute(self, city1, city2, flag):
        if(city1 == city2):
            print "no such route";
        c = 0;
        index = 0;
        for route in self.routeList:
            if ((route["ports"][0] == city1 or route["ports"][1] == city1) and (route["ports"][0] == city2 or route["ports"][1] == city2)):

                del self.routeList[index];
                c = 1;
            index = index + 1;
        if(c == 1):
            print "deleted the route in between " + city1 + " and " + city2;
            for city in self.cityList:
                if(city["code"] == city1):
                    del city["neighbor"][city2]
                if(city["code"] == city2):
                    del city["neighbor"][city1]
            
        else:
            if flag:
                print "no such route";

    
    def addCity(self):
        city = {};
        city_name = raw_input("Please enter the city name:");
        city_code = raw_input("Please enter the city code:");
        city_country = raw_input("Please enter the country of city:");
        city_continent = raw_input("Please enter the continent of the city:");
        city_timezone = input("please enter the timezone:");
        city_coord_N = input("please enter the N of coordinate:");
        city_coord_W = input("please enter the W of coordinate:");
        city_population = input("please enter the population of the city:");
        city_region = input("please enter the region code of the city:") ;
        city["name"] = city_name;
        city["code"] = city_code;
        city["country"] = city_country;
        city["continent"] = city_continent;
        city["timezone"] = city_timezone;
        city["coordinates"] = {"N" : city_coord_N, "W" : city_coord_W};
        city["population"] = city_population;
        city["region"] = city_region;
        city["neighbor"] = {};
        self.cityList.append(city);
    
    def addRoute(self):
        route = {};
        route_port1 = raw_input("Please enter the first port:");
        route_port2 = raw_input("Please enter the second port:");
        route_distance = input("Please enter the distance:");
        route["ports"] = [route_port1, route_port2];
        route["distance"] = route_distance;
        
        self.updateRouteInCity(route);
    
    def updateRouteInCity(self, route):
        self.routeList.append(route);
        tempPortList = route["ports"];
        tempDistance = route["distance"]
        for city in self.cityList:
            if(city["code"] == tempPortList[0]):
                city["neighbor"][tempPortList[1]] = {tempDistance}
            elif(city["code"] == tempPortList[1]):
                city["neighbor"][tempPortList[0]] = {tempDistance}
    
    def editingCity(self):
        cityName = raw_input("Please enter the city name which you want to edit:");
        editCity = None;
        for city in self.cityList:
            if(city["name"].lower() == cityName.lower()):
                editCity = city;
                break;
        if(editCity == None):
            print "no such city exists";
            return;
        else:
            editPart = "";
            while(editPart != "exit"):
                editPart = raw_input("Which part of data you want to edit? enter exit to exit");
                if(editCity.has_key(editPart) and editPart != "code"):
                    fix = input("What you want it to changed to? use '' if it is a string ");
                    editCity[editPart] = fix; 
                elif(editPart == "code"):
                    fix = raw_input("What you want it to changed to?");
                    for route in self.routeList:
                        if(route["ports"][0] == editCity["code"]):
                            route["ports"][0] = fix;
                        if(route["ports"][1] == editCity["code"]):
                            route["ports"][1] = fix;
                        editCity["code"] = fix;
                else:
                    if(editPart != "exit"):
                        print "no such key exist in city"
                    
    def SaveGraphToDisk(self, fileName):
        
        outputCity = [];
              
        for city in self.cityList:
            tempCity = [];
            tempCity= copy.deepcopy(city);
            del tempCity["neighbor"];
            outputCity.append(tempCity);
        
        output = {"metros" : outputCity, "route" : self.routeList}
        
        fp = open(fileName, "w");
        json.dump(output, fp, indent=4, separators=(',', ':'));
        fp.close();
        print("Success!")

    ## all of the below are using routelist as a list of route
    def totalDistanceOfRoute(self, routeList):
        total = 0.0;
        for route in routeList:
            total = total + route["distance"];
        return total;
    

    def costOfRoute(self, routeList):
        distance = self.totalDistanceOfRoute(routeList);
        return (distance*0.35)
    
    def timeOfRoute(self, routeList):
        distance = self.totalDistanceOfRoute(routeList);
        return (distance/800);
    
    def addGraph(self, url):

        def convert(inputSource):
            if isinstance(inputSource, dict):
                return {convert(key): convert(value) for key, value in inputSource.iteritems()}
            elif isinstance(inputSource, list):
                return [convert(element) for element in inputSource]
            elif isinstance(inputSource, unicode):
                return inputSource.encode('utf-8')
            else:
                return inputSource

        myData = urllib2.urlopen(url)
        csAirData = json.load(myData)
        csAirData = convert(csAirData);
        routes = csAirData["routes"];
        cities = csAirData["metros"];
        
        for city in cities:
            self.cityList.append(city);
            city["neighbor"] = {};
            print "city: " + city["name"] + " added"
        for route in routes:
            self.updateRouteInCity(route);
            print "route: " + route["ports"][1] + " added"
            
    def findShortestPath(self,start,dest):
        result = [];
        
        return result;
