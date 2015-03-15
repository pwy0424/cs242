'''
Created on 03/05/2014

@author: Weiyang
'''
import sys;

class GraphUtility:
    
    #    Get all the information of a specific city 
    def getInfoOfCity(self, graph, cityName):
        for city in graph.cityList:
            if(city["name"].lower() == cityName.lower()):
                return city; 
        return None;
    
    #  Queries:
    # the longest single flight in the network:
    def findLongestFlight(self,graph):
        longest = -1;
        result = None;
        
        for flight in graph.routeList:
            current = flight["distance"];
            if(longest < current):
                longest = current;
                result = flight;
        
        return result;

    # the shortest single flight in the network 
    def findShortestFlight(self,graph):
        shortest = sys.maxint;
        result = None;
        
        for flight in graph.routeList:
            current = flight["distance"];
            if(shortest > current):
                shortest = current;
                result = flight;
        
        return result;

    # the average distance of all the flights in the network    
    def findAverageDistance(self,graph):
        totalLength = 0;
        
        for flight in graph.routeList:
            totalLength += flight["distance"];
        
        return float(totalLength/len(graph.routeList));

    # the biggest city (by population) served by CSAir
    def findBiggestCity(self,graph):
        biggest = -1;
        result = None;
        
        for city in graph.cityList:
            current = city["population"];
            if(biggest < current):
                biggest = current;
                result = city;
                
        return result;
    
    # the smallest city (by population) served by CSAir
    def findSmallestCity(self,graph):
        smallest = sys.maxint;
        result = None;
        
        for city in graph.cityList:
            current = city["population"];
            if(smallest > current):
                smallest = current;
                result = city;
                
        return result;
 
    # the average size (by population) of all the cities served by CSAir
    def findAverageCitySize(self,graph):
        totalSize = 0;
        
        for city in graph.cityList:
            totalSize += city["population"];
        
        return float(totalSize/len(graph.cityList));
    
    # a list of the continents served by CSAir and which cities are in them
    def findServingContinentAndCity(self,graph):
        continent = [];
        listOfCity = [];
        for city in graph.cityList:
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
    def findHubCities(self,graph):
        hub = -1;
        result = [];
        for city in graph.cityList:
            current = len(city["neighbor"]);           
            if(hub == current):
                result.append(city);
            if(hub < current):
                hub = current;
                result = [city];


        return result; 
    


    
    
    
    
    
