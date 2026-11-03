## Part 2 Version 1:
### Model used: ChatGPT

**Simple Prompt:**
Are these reviews positive or negative?

**Typical output:**
After reviewing all 110 product reviews in your CSV file, the overall sentiment is mixed, but leans slightly negative.
Sentiment Analysis Results
  Negative
41
37.3% of reviews


 Positive
32
29.1% of reviews


 Mixed
22
20.0% of reviews


 Neutral
15
13.6% of reviews

Manual classification of 110 reviews. Mixed reviews contain both positive and negative feedback.

Examples from your dataset
Review ID	Sentiment	Reason
R006	Positive	Praises call quality and battery life
R003	Negative	Earbud stopped charging; no support response
R060	Mixed	Great battery life but terrible microphone
R037	Neutral	Simply states that the lightbulbs work
R022	Negative	Sarcastically complains that the backpack isn't waterproof

Important observation
Several reviews contain sarcasm, which can make sentiment analysis tricky.

For example, R030 says the kettle is fantastic but then reveals that it broke after just one week. Although it contains positive words, the actual sentiment is negative.

Conclusion: Negative reviews outnumber positive reviews by 9. However, a significant number contain mixed opinions, so the overall customer feedback is divided rather than overwhelmingly negative.

## Part 2 Version 2

**Improved prompt (role + defined categories + Constraint):**
You are a senior customer feedback analyst for an e-commerce brand.
The following reviews will be categorized into positive, negative, mixed, and neutral. You must Read sarcastic sentences like "Oh great, it broke on day two" as Negative, not Positive. You have to assign every review ID exactly one category. 

**Output:**
Customer Review Sentiment Classification
I analyzed all 110 customer reviews and assigned each review ID exactly one sentiment category.
Classification rules
- Positive
   — Expresses satisfaction, praise, or a good experience.
- Negative
   — Expresses dissatisfaction, complaints, defects, or sarcastic criticism.
- Mixed
   — Contains both positive and negative feedback.
- Neutral
   — States facts, asks questions, or expresses no clear positive or negative opinion.
Classification results
35
Positive

40
Negative

23
Mixed

12
Neutral

110 of 110 reviews classified

Complete review ID classification
110 reviews shown
All categories


Review ID	Sentiment
R001	Negative
R002	Mixed
R003	Negative
R004	Negative
R005	Mixed
R006	Positive
R007	Mixed
R008	Mixed
R009	Mixed
R010	Positive
R011	Negative
R012	Neutral
R013	Mixed
R014	Mixed
R015	Negative
R016	Neutral
R017	Positive
R018	Negative
R019	Negative
R020	Mixed
R021	Positive
R022	Negative
R023	Positive
R024	Negative
R025	Negative
R026	Positive
R027	Positive
R028	Negative
R029	Mixed
R030	Negative
R031	Negative
R032	Negative
R033	Positive
R034	Positive
R035	Positive
R036	Mixed
R037	Neutral
R038	Neutral
R039	Positive
R040	Positive
R041	Mixed
R042	Neutral
R043	Neutral
R044	Positive
R045	Positive
R046	Positive
R047	Positive
R048	Negative
R049	Negative
R050	Positive
R051	Negative
R052	Positive
R053	Negative
R054	Positive
R055	Mixed
R056	Mixed
R057	Negative
R058	Negative
R059	Mixed
R060	Mixed
R061	Positive
R062	Negative
R063	Mixed
R064	Positive
R065	Negative
R066	Negative
R067	Neutral
R068	Negative
R069	Positive
R070	Positive
R071	Mixed
R072	Mixed
R073	Mixed
R074	Negative
R075	Mixed
R076	Negative
R077	Positive
R078	Negative
R079	Positive
R080	Negative
R081	Positive
R082	Positive
R083	Positive
R084	Mixed
R085	Negative
R086	Positive
R087	Neutral
R088	Positive
R089	Positive
R090	Positive
R091	Negative
R092	Neutral
R093	Negative
R094	Neutral
R095	Negative
R096	Negative
R097	Mixed
R098	Negative
R099	Mixed
R100	Negative
R101	Neutral
R102	Positive
R103	Negative
R104	Neutral
R105	Positive
R106	Negative
R107	Negative
R108	Negative
R109	Negative
R110	Negative

 Copy all 110 as CSV

Important sarcasm checks
These reviews contain positive-sounding words but express negative experiences.
Review ID	Actual meaning	Classification
R022	Supposedly waterproof backpack soaked the contents	Negative
R024	Smart bulbs lost their settings	Negative
R030	Kettle broke after one week	Negative
R066	Earbuds repeatedly fall out	Negative
R068	Blanket is itchy and thin	Negative
R078	Blanket still smells after multiple washes	Negative
R080	Backpack buckle broke during a hike	Negative
R085	Kettle makes water taste like plastic	Negative
R098	Smart bulbs require router troubleshooting	Negative
R108	Earbuds frequently disconnect after three days	Negative

Validation: All 110 review IDs (R001–R110) are accounted for, with exactly one category per ID and no duplicates.

## Part 2 Version 3:

**Improved prompt (role + defined categories + Constraint + output format):**
You are a senior customer feedback analyst for an e-commerce brand.
The following reviews will be categorized into positive, negative, mixed, and neutral. You must Read sarcastic sentences like "Oh great, it broke on day two" as Negative, not Positive. You have to group all the sentiment categories together. Return the table with these columns: Review #, Product, Sentiment, Key Evidence.

**Output:**
Customer Review Sentiment Analysis
I analyzed all 110 customer reviews, classifying them into four sentiment categories based on the customer's actual experience and tone.

Classification rules:
- Positive
   Clear satisfaction, praise, or a recommendation.
- Negative
   Dissatisfaction, defects, complaints, or sarcasm expressing frustration.
- Mixed
   Both positive and negative feedback in the same review.
- Neutral
   Factual statements, questions, or opinions without strong positive or negative sentiment.
Sarcastic comments such as “Oh good, a kettle that makes my water taste like plastic” are classified as Negative.
1. Positive Reviews
Review #	Product	Sentiment	Key Evidence
R006	Breeze Wireless Earbuds	Positive	Clear calls, good battery, perfect for commuting
R010	Hearth Electric Kettle	Positive	Repeat purchase; reliable after a year
R017	Trailmark Hiking Backpack	Positive	Extremely durable in rough conditions
R021	Trailmark Hiking Backpack	Positive	Excellent value and premium feel
R023	Lumen Smart Bulbs (4-Pack)	Positive	Sunrise alarm improves mornings
R027	Hearth Electric Kettle	Positive	Fast boiling and attractive design
R033	Breeze Wireless Earbuds	Positive	Best purchase of the year
R034	Lumen Smart Bulbs (4-Pack)	Positive	Easy setup, vibrant colors, useful scheduling
R035	Lumen Smart Bulbs (4-Pack)	Positive	Purchased another pack due to satisfaction
R039	Hearth Electric Kettle	Positive	Attractive enough to draw coworkers' interest
R040	Cozy Knit Throw Blanket	Positive	Durable despite frequent use
R044	Trailmark Hiking Backpack	Positive	Comfortable, durable, practical pockets
R045	Cozy Knit Throw Blanket	Positive	Perfect weight for summer evenings
R046	Cozy Knit Throw Blanket	Positive	Very soft and warm
R047	Trailmark Hiking Backpack	Positive	Strong recommendation for beginners
R050	Hearth Electric Kettle	Positive	Excellent spout control for pour-over coffee
R052	Breeze Wireless Earbuds	Positive	Exceeded expectations; would repurchase
R054	Breeze Wireless Earbuds	Positive	Comfortable with instant pairing
R061	Trailmark Hiking Backpack	Positive	Durable through a full school year
R064	Trailmark Hiking Backpack	Positive	Comfortable on a five-day trek
R069	Cozy Knit Throw Blanket	Positive	Strong enthusiasm and plans to repurchase
R070	Lumen Smart Bulbs (4-Pack)	Positive	Enjoys the cozy warm-white setting
R077	Breeze Wireless Earbuds	Positive	Excellent sound, bass, and secure fit
R079	Cozy Knit Throw Blanket	Positive	Both gift recipients love their blankets
R081	Cozy Knit Throw Blanket	Positive	Washes well without pilling
R082	Trailmark Hiking Backpack	Positive	Ideal day-hike size and useful hydration sleeve
R083	Cozy Knit Throw Blanket	Positive	Premium appearance and compliments
R086	Lumen Smart Bulbs (4-Pack)	Positive	Alexa integration improves accessibility
R088	Lumen Smart Bulbs (4-Pack)	Positive	Music synchronization works well at parties
R090	Hearth Electric Kettle	Positive	Beautiful, fast, quiet, no complaints
R102	Cozy Knit Throw Blanket	Positive	Best blanket owned; heavy, warm, and soft
R106	Hearth Electric Kettle	Positive	Fast and attractive kettle

2. Negative Reviews
Review #	Product	Sentiment	Key Evidence
R001	Trailmark Hiking Backpack	Negative	Strong chemical smell lasting a week
R003	Breeze Wireless Earbuds	Negative	Earbud stopped charging; support unresponsive
R004	Trailmark Hiking Backpack	Negative	Uncomfortable straps; returning product
R011	Cozy Knit Throw Blanket	Negative	Arrived stained
R015	Trailmark Hiking Backpack	Negative	Smaller than advertised
R018	Lumen Smart Bulbs (4-Pack)	Negative	Washed-out colors
R019	Trailmark Hiking Backpack	Negative	Seller shipped incorrect size
R022	Trailmark Hiking Backpack	Negative	Sarcasm: waterproof claim failed; contents soaked
R024	Lumen Smart Bulbs (4-Pack)	Negative	Sarcasm: update erased settings
R025	Lumen Smart Bulbs (4-Pack)	Negative	Annoying buzzing when dimmed
R028	Breeze Wireless Earbuds	Negative	Constant static; product returned
R030	Hearth Electric Kettle	Negative	Sarcasm: switch broke after one week
R031	Lumen Smart Bulbs (4-Pack)	Negative	Frequent app crashes and unresponsive bulbs
R032	Hearth Electric Kettle	Negative	Keep-warm function too short
R048	Hearth Electric Kettle	Negative	Dangerous leaking near electrical outlet
R049	Hearth Electric Kettle	Negative	Overheating handle caused a burn
R051	Hearth Electric Kettle	Negative	Power cord too short
R053	Lumen Smart Bulbs (4-Pack)	Negative	One bulb dead on arrival
R057	Hearth Electric Kettle	Negative	Slow shipping and wet packaging
R058	Cozy Knit Throw Blanket	Negative	Excessive shedding
R062	Breeze Wireless Earbuds	Negative	Shipping took three weeks
R065	Trailmark Hiking Backpack	Negative	Zipper broke on first hike
R066	Breeze Wireless Earbuds	Negative	Sarcasm: earbuds constantly fall out
R068	Cozy Knit Throw Blanket	Negative	Sarcasm: itchy and thin material
R074	Hearth Electric Kettle	Negative	Mineral buildup despite filtered water
R076	Breeze Wireless Earbuds	Negative	Extremely dissatisfied; advises against purchase
R078	Cozy Knit Throw Blanket	Negative	Sarcasm: warehouse smell remains after washing
R080	Trailmark Hiking Backpack	Negative	Sarcasm: buckle broke during mountain hike
R085	Hearth Electric Kettle	Negative	Sarcasm: water tastes like plastic
R091	Hearth Electric Kettle	Negative	Lid fails to close; steam escapes
R093	Cozy Knit Throw Blanket	Negative	Delivery left exposed to rain
R095	Trailmark Hiking Backpack	Negative	Stitching coming apart after two uses
R096	Lumen Smart Bulbs (4-Pack)	Negative	Unwanted account and location-data requirements
R098	Lumen Smart Bulbs (4-Pack)	Negative	Sarcasm: unreliable smart-home operation
R100	Lumen Smart Bulbs (4-Pack)	Negative	Stopped working after one month
R103	Breeze Wireless Earbuds	Negative	Tinny sound and uncomfortable fit
R107	Cozy Knit Throw Blanket	Negative	Unraveling after one month
R108	Breeze Wireless Earbuds	Negative	Sarcasm: frequent disconnections after three days
R109	Breeze Wireless Earbuds	Negative	Cheap charging case; broken lid
R110	Lumen Smart Bulbs (4-Pack)	Negative	Brightness below advertised claim

3. Mixed Reviews
Review #	Product	Sentiment	Key Evidence
R002	Breeze Wireless Earbuds	Mixed	Good for gym, but noise cancellation is misleading
R005	Cozy Knit Throw Blanket	Mixed	Decorative use is fine, but insufficient warmth
R007	Trailmark Hiking Backpack	Mixed	Good value but unsuitable for serious backpacking
R008	Lumen Smart Bulbs (4-Pack)	Mixed	Bright colors but recurring Wi-Fi disconnections
R009	Lumen Smart Bulbs (4-Pack)	Mixed	Great bulbs but poor app
R013	Hearth Electric Kettle	Mixed	Original failed; replacement works so far
R014	Hearth Electric Kettle	Mixed	Arrived dented but replacement was shipped quickly
R020	Trailmark Hiking Backpack	Mixed	Incorrect color but otherwise good bag
R029	Breeze Wireless Earbuds	Mixed	Acceptable for podcasts but poor for music
R036	Cozy Knit Throw Blanket	Mixed	Wrong color delivered but still nice
R041	Trailmark Hiking Backpack	Mixed	Well made but too many confusing pockets
R055	Hearth Electric Kettle	Mixed	Useful temperature settings but excessively loud beep
R056	Breeze Wireless Earbuds	Mixed	Crushed packaging but earbuds work well
R059	Trailmark Hiking Backpack	Mixed	Waterproof performance good; hip belt lacks padding
R060	Breeze Wireless Earbuds	Mixed	Excellent battery life but terrible microphone
R063	Hearth Electric Kettle	Mixed	Fast boiling but limited capacity
R071	Cozy Knit Throw Blanket	Mixed	Beautiful and cozy but shrank in wash
R072	Breeze Wireless Earbuds	Mixed	Inferior to AirPods but good value for price
R073	Lumen Smart Bulbs (4-Pack)	Mixed	Acceptable value but customer prefers another brand
R075	Cozy Knit Throw Blanket	Mixed	Very soft but smaller than expected
R084	Lumen Smart Bulbs (4-Pack)	Mixed	Initial pairing issue resolved by helpful support
R097	Breeze Wireless Earbuds	Mixed	Great sound but frustrating touch controls
R099	Cozy Knit Throw Blanket	Mixed	Attractive appearance but snags easily
R105	Hearth Electric Kettle	Mixed	Otherwise perfect but limited color options

4. Neutral Reviews
Review #	Product	Sentiment	Key Evidence
R012	Lumen Smart Bulbs (4-Pack)	Neutral	Asks about Google Home compatibility
R016	Trailmark Hiking Backpack	Neutral	Described simply as “fine”
R026	Lumen Smart Bulbs (4-Pack)	Neutral	Factual statement about early delivery
R037	Lumen Smart Bulbs (4-Pack)	Neutral	Simply states that bulbs provide light
R038	Breeze Wireless Earbuds	Neutral	Neither strongly good nor bad
R042	Cozy Knit Throw Blanket	Neutral	Acceptable for the price
R043	Hearth Electric Kettle	Neutral	Does the job; nothing special
R067	Trailmark Hiking Backpack	Neutral	Question about laptop sleeve size
R087	Cozy Knit Throw Blanket	Neutral	Question about product dimensions
R089	Trailmark Hiking Backpack	Neutral	Initial observation; looks nice
R092	Cozy Knit Throw Blanket	Neutral	Basic statement about blanket functionality
R094	Breeze Wireless Earbuds	Neutral	Gift has not been opened or tested
R101	Breeze Wireless Earbuds	Neutral	Question about PS5 compatibility
R104	Hearth Electric Kettle	Neutral	Basic statement about boiling water

Sentiment Summary
32
Positive
29.1%

40
Negative
36.4%

24
Mixed
21.8%

14
Neutral
12.7%

110 reviews classified100% coverage


Key Findings
1. Negative feedback is the largest category (36.4%). Common complaints include product failures, durability issues, connectivity problems, and misleading descriptions.
2. Positive feedback accounts for 29.1%. Customers frequently praise comfort, value, attractive designs, and reliable performance.
3. Mixed feedback represents 21.8%. These customers appreciate certain features but identify specific improvements.
4. Neutral feedback accounts for 12.7%. These reviews mostly contain product questions, basic observations, and mild opinions.
Important observation: Several negative reviews use sarcasm to disguise frustration. Reviews R022, R024, R030, R066, R068, R078, R080, R085, R098, and R108 were correctly interpreted as Negative despite containing seemingly positive words.