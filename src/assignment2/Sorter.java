package assignment2;

class Sorter {
    int floor;
    
    public Sorter(int floor) {
        this.floor = floor;
    }
    
    @Override
    public String toString() {
        return String.format("%02d", floor);
        
        
    }
}

