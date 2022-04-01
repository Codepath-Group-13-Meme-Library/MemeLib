# MemeLib

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview
### Description
[Description goes here]

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** 
- **Mobile:**
- **Story:**
- **Market:**
- **Habit:** 
- **Scope:** 

## Product Spec
### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Sign in/Sign up (Parse server)
* Post images (File)
  * Must be a user to post an image
  * Timestamp when it was posted 
  * Delete
  * Description (to be decided)
  * Edit
* Put images in collections/themes (pointer) *Public*
* Put tags for images *Public*
* Favorites
  * Need to be logged in
  * specific/private (tbd) to the user


**Optional Nice-to-have Stories**

* Post video/GIF (TBD) (File)
* Better UI
* Background themes/customize app color
* Sounds when clicked etc.
* App Icon
* Private/public favorites
* Reactions to posts (thumbs up, heart, etc.)
* Profile fragment
* Share post on another app like (whatsapp, instagram, snapchat, discord, etc.)
* Share meme on another app (Sending simple data to other apps)

### 2. Screen Archetypes

* Splash screen
* Login/Sign up screen with continue without logging in (only can see posts, cannot upload)
* Main page
  * Public collections, search bar, navigation panes etc
  * Upload button if user signed in
    * If user is not logged in, the upload button will take them to the login screen, and then after logging in, they can upload
  * Fragments
    * Collections/Favorites
    * Main page
* Post screen

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* When clicked on collections tab, takes you to collections screen
* When clicked on main (middle) tab, takes you back to main page where posts are present

Optional:

**Flow Navigation** (Screen to Screen)

* When user logs in or continues without logging in, takes them to main page
* When user clicks on upload button on main page, takes them to post screen, else: takes them to login and then post screen

## Wireframes
<img src="IMAGE" width=800><br>

### [BONUS] Digital Wireframes & Mockups
<img src="IMAGE" height=200>

### [BONUS] Interactive Prototype
<img src="GIF" width=200>
