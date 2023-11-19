package com.example.event.Controller;

import com.example.event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<Event>events=new ArrayList<>();
    @PostMapping("/add")
    public String addEvent(@RequestBody Event e){
        events.add(e);
        return "event added";
    }
    @GetMapping("/display")
    public ArrayList<Event>display(){
        return events;
    }
    @PutMapping("/update/{index}")
    public String update(@PathVariable int index,@RequestBody Event e){
        events.set(index,e);
        return "event updated";
    }
    @DeleteMapping("/delete/{index}")
    public String delete(@PathVariable int index){
        events.remove(index);
        return "event deleted";
    }
    @PutMapping("/change/{index}")
    public String change(@PathVariable int index,@RequestBody int newCapacity){
        events.get(index).setCapacity(newCapacity);
        return "capacity changed";
    }
    @GetMapping("/search/{id}")
    public String searchEvent(@PathVariable String id){
        for(Event e:events){
            if(e.getId().equals(id)){
                return "event : "+e;
            }
        } return "not found";
    }
}
