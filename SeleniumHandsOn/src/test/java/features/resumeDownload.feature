Feature: Download sample resume

Scenario: Download Software Engineer resume

Given user is in recruitment section
When user select Job title
And clicks on download
Then resume should get download