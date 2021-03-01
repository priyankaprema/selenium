Feature: Search Leave days

Scenario: Search Leaves on selected date(s)

Given user is on search leave page
When user enters From and To date
Then all the leaves should be displayed in between selected date