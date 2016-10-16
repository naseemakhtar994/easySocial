# easySocial
easily launch any social app with your page/profile/etc.

pros:

Adding social media integration is great for your app & users because it allows those same users to do the following:

1. read up on your updates/messages/etc

2. share crap about your app with all their friends/families/co-workers/you name it(more users may even try your app!)

3. basically free advertisement/ratings shared to thousands of people!

cons:

Adding social media integration MAY NOT be great for your app & users because it allows those same users to LEAVE your app...& if you send them to a SOCIAL MEDIA APP...then they might not EVER return to your app...so bear that in mind!

BUT, hey I am developer in his infancy so what the hell do I know?

Have you ever found it difficult to add social media integration into any of your apps?


-I am not just talking about "logging" in/out or even signing up, but allowing your users to visit all of your social media pages/profiles/etc inside each respective social media app.

I spent hours trying to do just that...however when one method did work...but ONLY upto a certain SDK or even app version(facebook was a huge d*ck about that!)
But, I still faced huge problems
-app installed, not enabled
-no internet connection
-version/sdk specific method
-something bullshit you probably faced here!

So I did even more research (GOGLE!) & came up with a great solution & even wrapped it in a simple "API" for your social media needs.

At The Moment I Only Support: "ATMIOS"
-Facebook
-twitter
-google plus
-youtube
-rate app(basically open google play/aptoide/etc.(aptoide is not all about piracy & its a great SOURCE to distribute your app to!)

PLEASE request to add more social apps!

this will be my first open source library ever & yes I will share code freely & even drop a jar/aar on jcenter still deciding which will be better.

Now that we got all that out of the way...lets see that magical code I keep talking about!

i have the following public static strings:
A_SOCIAL_MEDIA_NAME_APP
for EX:
FACEBOOK_APP which equals "app.id.here"
(if you didn't catch on the name scheme..i feel SO sorry for you)

this way you can call this yourself too to save you even more trouble without having to remember app id's!

//since i didn't make the jar/aar/libary yet(its actually a ton code pulled from my main closed source app that I think will benefit developers like it did for me!)

BUT for now I will tell you the benefits/features:

0. every social media method is a public static boolvoid(a boolean & void) which can check if the app is installed sending you to the new app & if not return false allowing you to use a backup system(ex. webview/etc)

1. checks for internet access internally/another method will allow you to add your own internet boolean from activity/fragment instead of using my internal internet boolean.

2. a custom toast/snackbar to show if app not installed/internet is not available(you provide your own strings for each)

3. progress dialog to wait for the social app to launch.(some apps may take longer to launch for specific/unwkown reasons)

Probably many more features/custom/customizable stuff to implement!

stay tuned for more soon!
