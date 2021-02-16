Feature:  Application Login

Scenario: Home Page Login default
Given User is on Landing Page
When  User logs in with username and  password
Then  Home page is populated
And  Cards are displayed
