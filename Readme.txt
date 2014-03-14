Run Instructions:
Must be run with one argument which spcifies the location of the environment.properties file.
Environment.properties specifies location of the users and tweets files.
It also specifies the type of file being imported: ASCII or PLAINTEXT

Assupmtions:
Environment is running java 7. (for the switch on strings statement)
Usernames are unique.
Usernames are case sensitive.
The users file will strictly follow the format provided with regards to layout and spacing. Same for the tweets file.
users & tweets files will only be loaded on application startup.
There will be no tweets from users in the tweets.txt file that are not in the users.txt file.
Ascii files are in the format: 012 983 071 (three digits and a space.)

Should have been implemented/done better/Questions:
Logging.
Instead of using a list of Strings for the other users a user follows, it should have been a list of users. That would have meant that I would have had to override the equals for User object comparison.
Struggled with variable naming. Should the variable name contain the type as well? i.e usersHashMap?
Is it good practice to have a switch statement based on strings? What would be a better way?