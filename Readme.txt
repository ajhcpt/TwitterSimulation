Run Instructions:
Must be run with one argument which spcifies the location of the environment.properties file.
Environment.properties specifies location of the users and tweets files.
It also specifies the type of file being imported: ASCII or PLAINTEXT

Assupmtions:
Usernames are unique.
Usernames are case sensitive.
user file will only be loaded on application startup.
There will be no tweets from users in the tweets.txt file that are not in the users.txt file.
Ascii files are in the format: 012 983 071 (three digits and a space.)

Should have been implemented:
Logging.
Instead of using a list of Strings for the other users a user follows, it should have been a list of users. That would have meant that I would have had to override the equals for User object comparison.
Not enough tests.