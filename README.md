# SoftwareEngineeringTestingEksamen
Eksamensoppgave SET Gruppe 15

The following functionality has been added to the project:

Admin:

- Admin can view a list of users and delete them.
- Admin can view a list of guides and delete them.
- Admin can view a list of trips and delete them.
- When Admin deletes a trip, the trip will also be deleted from the user's trip list if the user has booked the trip.

User:

- User can create an account.
- User can edit user information.
- User can view an overview of trips.
- User can book a trip.
- User can view a list of booked trips.
- User can unbook trips.

Guide:

- Guide can create a guide profile.
- Guide can edit user information.
- Guide can add a trip.
- Guide can view a list of all trips they organize.
- Guide can delete a trip they organize. This trip will also be deleted from the user's trip list if the user has booked the trip.

System:

- All users can log in and out.
- The system remembers the logged-in profile.
- The system requires a username to log in as a Guide, User, or admin and prompts you to create a username if it does not match the information in the database.
- The system displays error messages if you have made a mistake or if the system cannot handle the request.
- For example:
  - Trying to book a trip without selecting one.
  - Trying to book a trip that is already booked.
  - Trying to unbook a trip without selecting one.
  - Trying to delete a profile (Guide, User) without selecting a profile.
  - Trying to create a profile (Guide, User) without filling out all the fields.
  - Trying to add a trip as a guide without filling out all the fields.

Improvements:

- When Admin deletes a Guide, the guide's trips should also be deleted.
