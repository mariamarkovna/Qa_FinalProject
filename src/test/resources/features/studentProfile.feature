Feature:Student role.View student profile in Student directory

  Scenario: Searching student profile in the Student Directory
  #HomePage
    Given that we navigate to home page
    And we click SignIn button in Header
    #SignInFormPage
    When we see a SignIn form
    Then we enter valid creds of existing user
    And we click SignIn button

    #HeaderMenuUser
    When user icon shows that we're logged in
    Then we click Student Directory button

    #StudentDirectoryPage
    When we see 'Welcome to our student directory'
    Then we enter existing name of Student in search field
    And we see profile of this student
    When we press View Profile button

    #StudentProfilePage
    Then we can see all information about this student
    And click profile icon
    When we see drop-down menu
    Then we click SignOut button

    #SignInFormPage
    Then we moved on SingIn Page
    And we close the driver





