package com.example.eventmanagement.controller;

import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }

    @PostMapping
    public String addEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + id));
        model.addAttribute("event", event);
        return "edit_event";
    }

    // Mapping for Update - functionally PUT
    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Event event) {
        event.setId(id);
        eventRepository.save(event);
        return "redirect:/events";
    }

    // Show confirmation page
    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + id));
        model.addAttribute("event", event);
        return "delete_confirm";
    }

    // Perform actual delete
    @GetMapping("/perform-delete/{id}")
    public String deleteEventConfirmed(@PathVariable Long id) {
        System.out.println("Deleting event with ID: " + id);
        eventRepository.deleteById(id);
        return "redirect:/events";
    }

    // Strict REST Endpoints as requested, though JSP forms default to GET/POST.
    // These can be tested via Postman or if we use HiddenHttpMethodFilter.
    // Ideally for "simple to explain", the above are practical.
    // I will add the strict mappings as redirects or aliases to be safe if they try
    // exact REST calls.

    @PutMapping("/{id}")
    @ResponseBody
    public Event updateEventRest(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
        return eventRepository.save(event);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteEventRest(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "Event deleted";
    }
}
