# MemeLib

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview
### Description
MemeLib is an entertainment app that allows people to easily store memes, put them in collections and favorites, share memes across the world with others, upload their own memes and explore memes on the internet or memes created by other users. Our goal is to enable people to share memes fast and easily on social media and make people laugh.

### App Evaluation
- **Category:** Entertainment
- **Mobile:** This app would be primarily developed for mobile.
- **Story:** We will be using a meme library API to pull memes from the internet, or users can manually upload their own memes and share with others or keep it private. Any user can view memes on the MemeLib app, but to upload memes they must log in or sign up.
- **Market:** Any individual could choose to use this app, and to keep it a safe environment, people would be organized into age groups.
- **Habit:** This app could be used as often or unoften as the user wanted depending on whether they are looking for a meme to send their friends, co-workers, families, or can be used if they want to have a laugh.
- **Scope:** People can use this app to store their favorite memes or put their memes in collections to easily find their memes and explore more memes. Large potential use for social media apps such as WhatsApp, Instagram, Facebook, Discord to find funny/reaction GIFs, pictures to share with others.

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


**Optional Nice-to-have Stories**

* Post video/GIF (File)
* Better UI
* Background themes/customize app color
* Sounds effects
* App Icon
* Private/public collections
* Reactions to posts (thumbs up, heart, etc.)
* Share meme on another app (like whatsapp, instagram, snapchat, discord, etc.)

### 2. Screen Archetypes

* Splash screen
* Login/Sign up screen with continue without logging in (only can see posts, cannot upload)
* Main page
  * Public collections, search bar, navigation panes etc
  * Upload button if user signed in
    * If user is not logged in, the upload button will take them to the login screen, and then after logging in, they can upload
  * Fragments
    * Collections/Favorites
    * Feed page
    * Post meme
       * If user is not logged in, the upload button will take them to the login screen, and then after logging in, they can upload

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* When clicked on collections tab, takes you to collections screen
* When clicked on feed tab, takes you back to feeds page where posts are present
* When clicked on post tab, if user is logged in takes them to post screen, else: takes them to login and then post screen

**Flow Navigation** (Screen to Screen)

* When user logs in or continues without logging in, takes them to main page
* Share button (Optional) allows the user to share a meme on another app.
* Logout button takes them to login page

## Wireframes
<img src="https://i.imgur.com/BmbCfbR.png" width=800><br>


### [BONUS] Digital Wireframes & Mockups
v.1.0.0
<img src="https://imgur.com/3hVzBKq.jpg" width=900>

### [BONUS] Interactive Prototype
v.1.0.0  
Click [here](https://kbz9pk.axshare.com) to play with the interactive prototype (password: codepath)
<img src="https://imgur.com/vxdmEox.gif" width=250>



## Schema 
### Models
#### Post

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | author        | Pointer to User| image author |
   | image         | File     | image that user posts |
   | caption       | String   | image caption by author |
   | likesCount    | Number   | number of likes for the post |
   | createdAt     | DateTime | date when post is created (default field) |
   
#### User

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | emailVerified | Boolean  | Used for email verification (Optional Story) |
   | username      | String   | User’s name (default field) |
   | password      | String   | Password to sign in the user (default field) |
   | collections   | Array of pointers to collections   | User’s collections |
   | email         | String   | Email used for password retrieval etc. (Optional Story) |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |

#### Collections

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | collection    | Array of pointers to posts| Collection list containing posts |
   | user          | Pointer to user  | Collection owner |
   | name          | String   | Name of collection |
   | description   | String   | Description for collection |
   | ACL           | ACL      | Permissions for the collection |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
   
 ### Networking
#### List of network requests by screen
   - Home Feed Screen
      - (Read/GET) Query all posts where user is author
         ```kotlin
         val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
         query.include(Post.KEY_USER)
         //return posts in descending order based on posted time
         query.addDescendingOrder("createdAt")
         query.findInBackground { posts, e ->
            if (e != null) {
                Log.e(TAG, "Error fetching posts")
            } else {
                //TODO: Do something with posts
            }
         }
         ```
      - (Create/POST) Create a new like on a post (optional story)
      - (Delete) Delete existing like (optional story)
   - Create Post Screen
      - (Create/POST) Create a new post object
   - Profile Screen
      - (Read/GET) Query logged in user object
      - (Create/POST) Create new collection
      - Collection Screen
        - (Update/PUT) Update Collection
        - (Read/GET) Posts in collection
       ```kotlin
       val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
       query.include(Post.KEY_USER)
       //only return posts from current clicked collection
       query.whereEqualTo(Post.KEY_COLLECTION, getCurrentCollection())
       //return posts in descending order based on posted time
       query.addDescendingOrder("createdAt")

       query.findInBackground { posts, e ->
          if (e != null) {
              Log.e(TAG, "Error fetching posts")
          } else {
              //TODO: Do something with posts
          }
       }
       ```
