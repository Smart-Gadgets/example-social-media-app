Requiremenrts: 
Design a social media app with following :

Crud operations on users
Retrieve a users feed/posts
Like/unlike a user Post.
follow or unfollow Users.


Tables:
 User table
userId name address profilePic email etc
xyz    abc  
 
 post table
postId postName postContent userId likes

 folow table
follower  follow
xyz       abc
xyz1      abc
 


Apis:
 user CRUD
/user   Post create an user
{
  userName: 
  userAddress: 
  email: 
  phoneNo: 

}
/user   Get  fetch user details
returns
{
userId:
userName:
userAddress:
email:
phoneNo:
}
/user   put  update user details
{
userId: @Nutnull
userName:
userAddress:
email:
phoneNo:
}
/user/{userid}   Delete delete an user


/user/{userId}/feed  Get 

{
  feedId:
  postName:
  postContent:
  userId:
  likes:
  
}

Like/unlike
/user/{userId}/feed Put
{
 feedAction - > like/unlike
}


follow/unfollow
/user/{userId}   put

{
 followAction -> follow/unfollow
}



