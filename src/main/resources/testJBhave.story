Meta:

Narrative:


As a user,
  I want to be able to create a new school event,
  So that I can add it to the school calendar.

Scenario: Creating a School Event
  Given a user logged in as an administrator
  When the user accesses the event creation page
  Then the user should see an event creation form

  When the user fills out the form with event details
    | nom       | date                 | lieu      | description         | capacite | organisateur
    | Event 1     | An event description        | 2023-11-01 10:00 | 202 | 20 | rahma
