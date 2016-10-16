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
But, I still faced huge problems:

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

//only 3 lines of codes gets you up & running!

1. must delare getActivity()/activity.this
2. boolean is to show toast message(if online/app not installed)
3. provide your own strings for the toast to use(if boolean is set to false you can set both strings as "" or leave it as it is)

                       //this is for  facebook PAGE so do NOT use ID's for this one
                        if(!openFacebookPage(getActivity(), "millercreativestudio", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        
                        //this a for a facebook PROFILE it can accept number id's & "normal" user names!
                        if(!openFacebookProfile(getActivity(), "100004301467504", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        
                        if(!openTwitterProfile(getActivity(), "xstar97", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        
                        if(!openGooglePlusCommunity(getActivity(), "101286674025561115431", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        
                        if(!openGooglePlusProfile(getActivity(), "", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
                        
                        if(!openYouTubeVideo(getActivity(), "dQw4w9WgXcQ", true, "not installed!", "no connection!")){
                            //app not installed...execute something here!
                        }
