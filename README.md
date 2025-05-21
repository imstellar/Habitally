# Android app overview
Over this GitHub page, I will document my process in creating a habit tracking app using Kotlin and Composables via Android Studio, this README file will contain any relevant documentation that occurs doing the process along with the justifications and explanations required by the assignment's criteria. You can also view any changes made via the commit history which can be found here, [https://github.com/imstellar/Habitally/commits/master/](https://github.com/imstellar/Habitally/commits/master/)

This file is split into parts based on the Assignment's specifications.

This project is utilising Kotlin and Jetpack Compose as its framework via Android Studio which is updated to the latest version throughout development.

## Assignment brief
Below is the assignment documentation that the app will be based from; 

## Scenario
You have been contacted by a local wellness spa and gym. They know you have completed a lot of research on mobile applications previously and have seen your web article. They want you to create a bespoke habit tracking application. Their only key requirements are the following:

- Should be able to track the amount of water someone has drunk in a day (Such as counting glasses of water drunk or litres etc)
- Should be able to track the number of workouts
- Should have a timer that can be used during workouts. 

Please note you do not have to save this information - The app just needs to have the functionality to display / run the above.

They are hoping to see your creativity and ideas with what other things you can add to your mobile application. 

## Task 1
You will first create a design for the application including user interface designs , use-case diagrams , some pseudo code etc. There should also be a creative aspect here with consideration of colour schemes and mentioning of other possible functionality you will or could add to the app additional to the wellness spa’s requirements.

Attempted criteria for this task;

- P3: Produce designs for a mobile app to meet identified requirements.
- P4: Review the mobile app designs with others to identify and inform refinements.
- M2: Justify how decisions made during the design process ensure the design for the app will meet identified requirements.

## Task 2
You are now to create the program. It will begin as a prototype so the looks do not have to exactly meet the plan but it is expected that the key functionality it presents. Therefore your mobile app should be able to do the following:
- Keep track of the amount of water someone has had in a day (User input)
- Be able to track the number of workouts in whichever way you feel would work
- Have some sort of timer that can be used to time workouts
- Has multiple screens OR One other creative function that would be suitable for a wellness gym / spa ( This is where you can show your creativity here)

Attempted criteria for this task;

- P5: Produce a mobile app that meets the design criteria.
- P6: Test a mobile app for functionality, usability, stability and performance.
- P7: Review the extent to which the mobile app meets the identified requirements.
- M3: Optimise a mobile app that meets the design criteria.

## Planning process
Here, lies the documentation for the Task 1 and its criteria, reading this section should fulfill the attempted criteria for that task respectively.

### Font
As a personal rule, I like to use the Montserrat Font Family when developing anything as I believe the font looks really good to look at and maintains accessibility. This font will be used only in the Regular, Medium and Bold styles in the application to preserve a well organised structure. This type of system is well known to ensure layouts in most interpretations feel organised, clear and concise without confusing the user with excess font styling changes.

### Colours
For colours, we will be using the Android's material theme which will be carefully implemented into the app by defining surface elements, primary/secondary containers and such, after doing so, each device will adapt the app's colour theme perfectly based on their phone's colour scheme, not only is this feature set extremely versatile, but it also automatically computes colours while making sure the contrast ratios are perfect and well suited.

### Images
While I have created some background images, I will attempt to utilise the colours of the material theme ruleset, the reasoning for this being that I want the app to follow most used material theme layouts present in modern android apps to keep it familiar. If any colours are used they will available to view inside the [drawable folder](/app/src/main/res/drawable/).

### Application interaction flow
Here, I would like to create a sort of use case diagram in my own way. To better fit the requirements of my application I will be using the "User" as the starting point which will then allow me to consider the actions that "User" will take to do a specific task within the app, eg. Changing a target, with that we can then display what the app needs to do after this interaction is triggered ag. Saving data.

This will be done using [https://draw.io](https://draw.io) and the result can be found [here](/Use-Cases.png).

### Mockup
For a well thought out project you always need to create designs, layouts and mockups that depict what the end result of the product should be. In this case I will use Axure RP 11 to create a design that features the previous considerations including the Use-Cases, Font, Colours and Images to create a mockup that can be used when creating the app, as this is my first time creating a fully fledged app expect major differences in the app's look.

My thought process when creating the mockup is to split the screen into different parts such as the app top bar, Water tracker, Workout tracker and Workout timer these parts can be split into different "Composable" elements in code making the project more modular and provide better stability. Working in this manner also provides the ability to better fit the client's requiremenets in the sense that it ensures each part of their criteria is met within the app and can be modified as needed without major code changes.

When it comes to development, I will utilise the mockup as a framework and try to reference as much of it inside the app while also making sure the app is utilising Material Theme's best practices, this may cause major deviations but it should be expected.

This mockup can be found in the github files as an Axure RP 11 project, [here](/app_mockup.rp) and as 2 PNG files, [home screen](https://gyazo.com/d0761ac93877aa0401d57e7bf5052078) and [target tracker](https://gyazo.com/1541c327509c443c1c7b69cba44942cd).

### Pseudocode
For pseudocode, I will only cover the functionality of the program, in parts, such as adding water to the tracker or removing it. As Kotlin Composables are extremely complex, these will not be included as they are there mainly for the layout of the program itself. When making this code I will split it up into functions that make up each part of the functionality, there will be no main loop or such as it's highly irrelevant in this scenario due to the fact that the user's actions will trigger events rather than a fixed loop.

The Pseudocode can be found as a text file [here](/Pseudocode.txt).

### Additional information
With all the above in consideration, during developement you must consider everyone that would use the app, in this case we should look at people that have additional needs, settings or specific types of devices. To ensure all these neeeds are met my planning process aims to ensure the text is readable, the colours are well-contrasted and the spacing is good for any user interaction no matter who the user may be. 

These points need to be constantly referenced when making the app to ensure the deviation from the original designs and such do not impair how the user of the app may be able to access its services. To do so I would like to use frameworks such as "Scaffolds" that create natural spacing from the top or bottom of the device screen, "Material Theme" which is a framework that allows the device to decide the right colours and text styles based on the user's selected theme and screen size of their device. The important part about these points is that all of it is incorporated into Android Studio by default and is ready to be used when needed without the requirement of upkeeping these features.

To get some feedback and review my app's designs, I have created a google form, this was made after the app is complete as the mockup and working application's designs differ significantly, this means I can grasp whether the mock-up looks better or the end resulting app making it way more efficient at getting the relevant information out of each user, you can view the responses to the form and its questions via [this link](https://docs.google.com/forms/d/1pacGuQfQYiJbzNevVQLiLMqdfrAh-WZVaLkFZf3NMqc/edit#responses)

The app design I have created is focused on meeting the client's explicit requirements as they have stated. To better explain, I have created each section for the app including the water tracker, workout tracker, workout timer and target setting sections each focused on filling one of the required points in the brief, this was done to ensure each part of my app fits the client's specifications by creating sections that fit each point perfectly.

## Developing process

### Layout
Now for the beginning of development, we will first create the layout using Jetpack Compose, this will also feature the Material Theme and it's typography, colours and elements. The app will contain well selected colours for each element but differ from the mock-up's design, I will however try to preserve as much of the mockup's text as possible because that will be needed.

As noted before, the app will feature a modular approach as each section will be separated into their own functions, this can be viewed in the main kotlin file [here](/app/src/main/java/com/assignment/habitally/MainActivity.kt).

### Project structure;
```
/com.assignment.habitally/

> MainActivity.kt, this stores the navigation bar including its functionality, top bar and hosts the data class from "data.kt".

> AppComponents.kt, this effectively stores blueprints for components such as "SectionHeader", "SectionDetails", "SectionTarget" and "SectionDivider" - these are @Composable functions that can be called easily from the other screens and provided with some basic text to implement saving time and reducing lines used.

> HomeScreen.kt, this is essentially the home page and its components, it is called when the app opens by the navHost inside "MainActivity.kt" by default, this could be classed as the MainActivity.

> TargetScreen.kt, this is the other screen used in the app for changing user's targets. The user can navigate to this screen by using the "Targets" button in the navigation bar or by hitting "Change" in any of the components storing the user's daily target information.

/com.assignment.habitally/data/
> data.kt, The main brains behind the user's semi-persistant storage, this stores an "AppState" class which is instanciated from "MainActivity.kt" and is provided to "HomeScreen.kt" and "TargetScreen.kt", where it can be read and modified as needed, storing the user's tracking data, target data and the functions that can be called to edit such data when needed. This implementation could be improved by dumping the class into app's storage for the data to stay after closing but this has not been implemented as it's not required for this project.
```
With all this information covered, I believe this displays how my app was developed, and just how well it meets the client's requirements. With this app design, code and functionality concluded I can confidently say there is more than enough functionality to fit each one of the requirements to the fullest;

- Should be able to track the amount of water someone has drunk in a day (Such as counting glasses of water drunk or litres etc)
    - This is fully met by providing the user with options to add water in ml in common variations, (glass and half a litre), this is them added together and displayed in easy to read formats.
- Should be able to track the number of workouts
    - Done by the workout section which stores the user's workout time and adding a "workout" activity each time the user submits the time. This is even more flexible than the water inputs as this uses a text field allowing the user to pick a specific time rather than +10 or -10 minutes found in the mock-up's design.
- Should have a timer that can be used during workouts.
    - This has been met by the workout timer section, not only is this perfectly implemented but it's interactivity is well thought-out making it simple to use and allowing the user to easily add this data to their workout tracking data after the timer is paused (which it must be paused and not in the "reset" state to be submitted else the buttons are disabled).

## Testing process

During the app's developement, I have had to resolve countless issues which spanned from annoyances to layout spacing issues and data persistance issues, I would like to go over any of the noteworthy issues I experienced;

```
Navigation Functionality
> The navigation bar had multiple issues at the start making it impossible to work with from the home screen, it prevented the user from changing to the target setting screen from any of the "your daily target" sections. This was a simple but confusing issue just requiring a function called "onNavigate" being passed to each activity which can be called from any of its composables.

Data persitance
> The data stored inside "data.kt" used to be implemented with a data class, this meant each time the user changed the screen they are on it got wiped, this was a completely unacceptable drawback which prompted me to turn it into a ViewModel class instead, this saved data when to each screen even if their current activity changes however it did not fix the issue of data sync between screens. That was fixed by instantiating (creating) the class inside MainActivity and passing it to the HomeScreen and TargetScreen meaning both screens used the same one instead of creating seperate ones.
```

## Conclusion

This was an extremely fun project but it had its downsides, I was able to learn some major parts of Kotlin and Jetpack Compose all by myself in such a short timespan and still create an app that I am extrememly proud of even going further than the requirements of the project itself by implementing a hole target system to allow users to set targets for themselves, I can concludew with this that my app is fully sufficient for this assignment.