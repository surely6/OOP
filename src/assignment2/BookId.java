/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

class BookId {
    int id;
    
    public BookId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return String.format("B%02d", id);
    }
}


