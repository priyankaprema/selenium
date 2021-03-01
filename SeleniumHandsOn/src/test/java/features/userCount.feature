Feature: Get user count

Scenario: To get the count of users with status Enabled

Given user is in user management page
When status is set to Enabled 
Then retrieve the count of users with status Enabled