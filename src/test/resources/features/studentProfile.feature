Feature:Student role.View student profile in Student directory

  Scenario: Searching student profile in the Student Directory
  #HomePage
    Given that we navigate to home page
    And we click SignIn button in Header
    #SignInFormPage
    Then we see a SignIn form
    When we enter valid creds of existing user
    And we click SignIn button

    #HeaderMenuStudent
    Then user icon shows that we're logged in
    When we click Student Directory button

    #StudentDirectoryPage
    Given that we see "Welcome to our student directory"
    Then we enter existing name of Student in search field
    And we see profile of this student
    When we press View Profile button

    #StudentProfilePage
    Then we can see all information about this student
    And click profile icon
    When we see drop-down menu
    Then we click SignOut button

    #SignInFormPage
    And we moved on SingIn Page
    * we close the driver





