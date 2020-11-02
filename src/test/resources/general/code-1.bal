type Coordinates record {|
    int latitude;
    int longitude;
|};

isolated class Hotels {

    private map<Coordinates> hotels = {};

    isolated function add(string name, Coordinates coordinates) {
        lock {
            self.hotels[name] = coordinates.clone();
        }
    }

    isolated function getCoordinates() returns map<Coordinates> {
        lock {
            return self.hotels.clone();
        }
    }
}