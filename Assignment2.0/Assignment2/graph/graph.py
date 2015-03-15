'''
Created on 02/26/2014

@author: Weiyang
'''


class Graph:

    # getting the graph from JSON.
    def __init__(self, city, route):
        self.cityList = city;
        self.routeList = route;
    
    # parse the graph 
    def getGraph(self):
        for route in self.routeList:
            tempPortList = route["ports"];
            tempDistance = route["distance"]
            
            for city in self.cityList:    
                if(city["code"] == tempPortList[0]):
                    city[tempPortList[1]] = {tempDistance}
                elif(city["code"] == tempPortList[1]):
                    city[tempPortList[0]] = {tempDistance}

    #    Get all the information of a specific city 
    def getInfoOfCity(self, cityName):
        for city in self.cityList:
            if(city["name"].lower() == cityName.lower()):
                return city; 
        return None
    
    #  Queries:
    # the longest single flight in the network:
    def findLongestFlight(self):
        longest = -1;
        result = None;
        
        for flight in self.routeList:
            current = flight["distance"];
            if(longest < current):
                longest = current;
                result = flight;
        
        return result;

    # the shortest single flight in the network 
    def findShortestFlight(self):
        shortest = 999999;
        result = None;
        
        for flight in self.routeList:
            current = flight["distance"];
            if(shortest > current):
                shortest = current;
                result = flight;
        
        return result;

    # the average distance of all the flights in the network    
    def findAverageDistance(self):
        totalLength = 0;
        
        for flight in self.routeList:
            totalLength += flight["distance"];
        
        return float(totalLength/len(self.routeList));

    # the biggest city (by population) served by CSAir
    def findBiggestCity(self):
        biggest = -1;
        result = None;
        
        for city in self.cityList:
            current = city["population"];
            if(biggest < current):
                biggest = current;
                result = city;
                
        return result;
    
    # the smallest city (by population) served by CSAir
    def findSmallestCity(self):
        smallest = 999999999999999;
        result = None;
        
        for city in self.cityList:
            current = city["population"];
            if(smallest > current):
                smallest = current;
                result = city;
                
        return result;
 
    # the average size (by population) of all the cities served by CSAir
    def findAverageCitySize(self):
        totalSize = 0;
        
        for city in self.cityList:
            totalSize += city["population"];
        
        return float(totalSize/len(self.cityList));
    
    # a list of the continents served by CSAir and which cities are in them
    def findServingContinentAndCity(self):
        continent = [];
        listOfCity = [];
        for city in self.cityList:
            new = 0;
            currentContinent = city["continent"]
            # find if it is not a new continent 
            for con in continent:
                if (con == currentContinent):
                    ind = continent.index(con);
                    listOfCity[ind].append(city["name"]);
                    new = 1;

            if(new == 0):
                continent.append(currentContinent);
                listOfCity.append([city["name"]]);

        result = {}
        for con, city in zip(continent, listOfCity):
            result[con] = city;
        return result; #return list
    
    # identifying CSAir's hub cities - the cities that have the most direct connections.
    def findHubCity(self):
        hub = -1;
        result = None
        for city in self.cityList:
            current = len(city);
            if(hub < current):
                hub = current;
                result = city;

        return result; 
    


    
    
    
    
    
