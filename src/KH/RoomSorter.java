package KH;

class RoomSorter {
    int room;

    public RoomSorter(int room) {
        this.room = room;
    }
    
    @Override
    public String toString() {
        return String.format("%02d", room);
    }
}

