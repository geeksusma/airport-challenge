# Airport Challenge
Challenge to test your domain modelling skills!

Since we only want to be focused in the domain, no persistence engine is needed. Thinking only in interfaces is a valid approach. Just let's see how you design Value Objects, Entities and Aggregates (or just components)

Please don't submit any PR to this repo. Just do a fork and commit all your changes there is good.

## The Challenge

We have an information system that it has its data fragmented, so we want to have a single source of truth, in order to keep our data centralised. And this data is based on Flights Operations.

To avoid complex solutions based on time zones, we can asume the time is always UTC.

To make this problem small, we’re not going to save more info than requested, of course it can be improved, adding extra validations or saving the seat number of the passenger in a flight. But it is not the goal by now

### Aircrafts, Routes, Cabin Crew and Passengers:

We have data about the aircrafts, like the manufacturer (Boeing... Airbus...) the model (747...) and their capacity (passengers and cabin crew) in number of seats.

For the capacity, we're interested in knowing, the minimum of people needed to drive the flight, and the minimum of passengers needed to avoid a cancellation. Also We need to know the maximum capacity for both, to avoid an overbooking.

The aircrafts are set in routes around the world, for the routes we’re saving the departure and the target airports, also the estimated time to arrival is important, and at what time is scheduled the departure.

We have two types of people that can join in a flight, the cabin crew and the passengers. For the cabin crew, we’re interested in knowing:

* Name, Last Name, Flight License, Rol, Company

For the passengers:
* Name, Last Name, Passport, Date of Birth, Tickets for one or more flights

### What is a flight?
So we can define a flight when it contains:

* A route to follow
* People on board including the cabin crew for that flight
* A flight also needs to have its own flight number

Also is important to know, for a flight, which is the Gate to proceed with the onboarding.

About the Gates, we want to know the *Gate Number* (it can be a number or an alphanumeric code) and in which terminal it is located)
there are some status, that could allow or disallow the onboarding of passengers. For example, only when the Gate is at ONBOARDING is when we can allow to the passengers take their seat at the airplane. Once the Gate is Closed, or when the gate is not defined at all, we can’t allow to passengers to go to their seat


### A trip

A trip contains one or more than one flight. This is specially important if the flight is split in different stages.

For example, a Flight from Sevilla to Munich can have a Stage at Mallorca. That would involve two flights. From Sevilla to Mallorca, and from Mallorca to Munich, so is important to have enough *time between both flights*, to allow to the passengers who are flying to Munich, to proceed with the on boarding of the remaining flight

When a trip with more than one flights is scheduled, we need to validate the second flight must happens before, at least 45 minutes before the departure time of the route.

### The onboarding process

Once the gate is assigned to a flight, then it can be opened for the onboarding of passengers. The onboarding must start 30 minutes before the departure date, otherwise the gate will remain closed. And only a Passenger is allowed to proceed with the onboarding if the gate remains at On-Boarding status.

For the Cabin Crew, we need to check if the same employee is not already onboarded, probably with a different role
For the Passengers, we need to check if it is already at the plane.
Also for passengers, they must have at least one ticket where the flight number is visible, to let us know he can proceed with the onboard

In both cases, we need to check if the capacity of the aircraft is enough, to avoid the situation of having an overbooking

Once the flight is 15 minutes before the departure time, the gate will get closed and no more people will be allowed to onboard

### First iteration.

#### Design the model

Design the model to represent all the elements listed before, and taking into account the basic domain rules needed.

To keep this exercise small, don't implement any validation not listed along the exercise.

Estimated time to design the model is 5 hours.

### Second iteration.

#### Setup trips

We want to design a component that will allow to define in the system a trip, including their stages (if the trip is a long one) and please verifying those stages are fulfilling the validations listed above

### Third iteration.

#### Onboarding process

We want to design another component to allow to us to proceed with the onboarding of passengers and cabin crew, taking into account, the gate must not be closed
