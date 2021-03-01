Feature: Delete User

Scenario: Successfull user deletion

Given usermanagement page with multiple users
When user select to delete empoyee details
Then employee records should be deleted
