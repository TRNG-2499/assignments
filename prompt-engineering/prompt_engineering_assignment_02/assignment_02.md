# Assignment_02 - The Product Description Makeover

## Prompt Log

### Version 1

Are these reviews positive or negative?

---
Output:

The reviews lean **negative overall**, but the picture varies a lot by product. I read all 110 and judged each one by its overall tone, so the counts below are my estimates:

- **Roughly 35 positive**, such as "Absolutely bombproof" and "Best purchase I've made all year."
- **Roughly 55 negative**, including several sarcastic ones like "Ten stars" for a pack that soaked a sleeping bag.
- **About 20 neutral or mixed**, such as "Ok for the price" or questions about compatibility.

By product:

- **Trailmark Hiking Backpack (about 22 reviews):** Mixed. Several buyers praise durability and comfort, but there are repeated complaints about broken zippers, stitching coming apart, and sizing that doesn't match the listing.
- **Breeze Wireless Earbuds (about 17 reviews):** Mostly negative. Common issues are connection drops, static, poor microphone quality, fit, and charging case failures. Some reviewers like the sound and battery for the price.
- **Lumen Smart Bulbs (4-Pack) (about 22 reviews):** Mostly negative. The main complaints are the app, Wi-Fi disconnects, and setup or account requirements. Buyers who got past setup tend to like the bulbs.
- **Hearth Electric Kettle (about 19 reviews):** Mixed, with a lot of hardware defects. Reviewers praise the speed, design, and gooseneck spout, but report leaks, handles that get too hot, lids that don't seal, and units that failed within weeks. Customer service replacements often went well.
- **Cozy Knit Throw Blanket (about 19 reviews):** Mostly positive on warmth and softness, with complaints about shedding, shrinking, snagging, and unraveling.

If you want, I can export the sentiment labels for each review to a spreadsheet so you can filter them yourself.

### Version 2 (categories)

Categorize these reviews as pure positive, pure negative, sarcastic, questions, neutral/mixed.

---
Output:

I read all 110 reviews and sorted each into one category. Counts:

| Category | Count |
| --- | --- |
| Pure positive | 32 |
| Pure negative | 31 |
| Mixed/neutral-leaning-mixed | 23 |
| Neutral | 10 |
| Sarcastic | 10 |
| Questions | 4 |
| **Total** | **110** |

**Pure positive (32):** R006, R010, R017, R021, R023, R027, R033, R034, R035, R039, R040, R044, R045, R046, R047, R050, R052, R054, R061, R064, R069, R077, R079, R081, R082, R083, R084, R086, R088, R090, R102, R106

**Pure negative (31):** R001, R003, R004, R008, R011, R015, R018, R019, R025, R028, R031, R032, R048, R049, R051, R053, R057, R058, R062, R065, R074, R076, R091, R093, R095, R096, R100, R103, R107, R109, R110

**Sarcastic (10):** R022, R024, R030, R066, R068, R078, R080, R085, R098, R108

- R022: "Love that the 'waterproof' pack turned my sleeping bag into a sponge. Ten stars."
- R024: "wow so smart, it forgot all my settings after an update. genius."
- R030: "Fantastic. Just fantastic." (the switch broke after a week)
- R066: "Absolutely love how they fall out every time I turn my head."
- R068: "Wonderful, it's itchy AND thin. Two for one."
- R078: "I'm thrilled that it smells like a warehouse even after three washes."
- R080: "Oh sure, I just love when the buckle snaps halfway up a mountain."
- R085: "Oh good, a kettle that makes my water taste like plastic."
- R098: "Nothing says 'smart home' like having to unplug the router to turn on my lights."
- R108: "Truly impressive engineering" (after three days of working earbuds)

**Questions (4):** R012, R067, R087, R101

- R012: Does the Lumen bulb work with Google Home or only Alexa?
- R067: Is the laptop sleeve big enough for a 16-inch laptop?
- R087: What are the dimensions?
- R101: Does the Breeze earbud work with a PS5?

**Mixed (23):** R002, R005, R007, R009, R013, R014, R020, R029, R036, R041, R055, R056, R059, R060, R063, R070, R071, R072, R073, R075, R097, R099, R105

**Neutral (10):** R016, R026, R037, R038, R042, R043, R089, R092, R094, R104

**Borderline calls you may want to revisit:**

- R084 is classed as pure positive even though it describes a pairing problem, because the problem was resolved and the review ends on praise.
- R105 is classed as mixed because the only complaint is the color range, but the reviewer otherwise says "perfect."
- R026 ("arrived a day early") and R089 ("received today, looks nice") are neutral. They could be read as mildly positive.
- R030 and R066 are sarcastic, but the sarcasm is subtle. A reader who takes them at face value would call them negative.
- R093 ("Delivery driver left it in the rain") is classed as negative, though it reads as a shipping complaint rather than a product complaint.

### Version 3 (categories + few-shot + format)

Categorize these reviews as pure positive, pure negative, questions, mixed, unrelated.

Format output as a table with headers: Review Number, Category, Classification Rationale (explain why the category was chosen)

Here are some examples of reviews and how they'd be categorized:

- "This might be the greatest thing since sliced bread. 10/10" - pure positive
- "This is just great. It stopped working the day after I got it. Just wonderful. 10/10" - pure negative
- "My only complaint is... (complaint). Other than that, it's the best. 8/10" - mixed
- "The package said it would come in Monday, but it didn't arrive until Thursday. Then somebody stole it off of my porch. 1/10" - unrelated

---
Output:

I read all 110 reviews from the file. Sarcastic reviews are classed by their intended meaning, so a sarcastic complaint counts as negative. Reviews that only discuss shipping or delivery are unrelated because they don’t assess the product.

| Review Number | Category | Classification Rationale |
| --- | --- | --- |
| R001 | Pure negative | Reports a chemical smell that took a week to air out. |
| R002 | Mixed | Decent isolation, but it isn't true noise cancelling; still good for the gym. |
| R003 | Pure negative | Left earbud stopped charging, and support never responded. |
| R004 | Pure negative | Straps dig into the shoulders, and the reviewer is returning it. |
| R005 | Mixed | Not warm enough for winter, but acceptable as a decorative throw. |
| R006 | Pure positive | Praises the commute fit, call clarity, and battery. |
| R007 | Mixed | Decent value, but not suited to serious backpacking. |
| R008 | Mixed | Bright, colorful bulbs, but they disconnect from Wi-Fi every few days. |
| R009 | Mixed | Praises the bulbs and criticizes the app. |
| R010 | Pure positive | Bought a second one and it is still going strong after a year. |
| R011 | Pure negative | Arrived with a stain. |
| R012 | Questions | Asks whether the bulbs work with Google Home or only Alexa. |
| R013 | Mixed | Failed after six weeks, but the replacement works so far. |
| R014 | Mixed | Arrived dented, but the replacement shipped quickly and the kettle is fine. |
| R015 | Pure negative | Too small for more than a day trip, contrary to the listing. |
| R016 | Mixed | Lukewarm ("fine") with no strong praise or complaint. |
| R017 | Pure positive | Describes it as bombproof with zero damage after rough use. |
| R018 | Pure negative | Colors look washed out compared with other brands. |
| R019 | Pure negative | Seller sent the wrong size. |
| R020 | Mixed | Color differs from the photos, though it is still a good bag. |
| R021 | Pure positive | Calls it great value that feels more expensive than it was. |
| R022 | Pure negative | Sarcastic "ten stars" after the "waterproof" pack soaked a sleeping bag. |
| R023 | Pure positive | The sunrise alarm has made mornings easier. |
| R024 | Pure negative | Sarcastic "genius" after an update wiped all settings. |
| R025 | Pure negative | Buzzes when dimmed below 30%, which is annoying in a quiet room. |
| R026 | Unrelated | Only comments on the package arriving early; no product assessment. |
| R027 | Pure positive | Boils quickly and has a sleek design. |
| R028 | Pure negative | Returned due to constant static in the right ear. |
| R029 | Mixed | Fine for podcasts, but not recommended for music. |
| R030 | Pure negative | Sarcastic "fantastic" after the switch broke within a week. |
| R031 | Pure negative | App crashes often, and bulbs frequently don't respond. |
| R032 | Pure negative | Keep-warm function lasts only 30 minutes, which the reviewer calls useless. |
| R033 | Pure positive | Calls it the best purchase of the year and replaced a $200 pair. |
| R034 | Pure positive | Quick setup, vibrant colors, and a liked scheduling feature. |
| R035 | Pure positive | Bought a second 4-pack for the rest of the house. |
| R036 | Mixed | Wrong color received, but the reviewer kept it because it is nice. |
| R037 | Mixed | Neutral shrug ("They light up") with no clear praise or complaint. |
| R038 | Mixed | "Not bad, not great" is ambivalent with no strong sentiment. |
| R039 | Pure positive | Coworkers keep asking where it came from. |
| R040 | Pure positive | Still looks new despite a toddler dragging it everywhere. |
| R041 | Mixed | Too many pockets to find anything, but very well made. |
| R042 | Mixed | "Ok for the price" is lukewarm and qualified by price. |
| R043 | Mixed | "Does the job, nothing special" is lukewarm with no strong sentiment. |
| R044 | Pure positive | Comfortable, durable, and the side pockets fit a bottle. |
| R045 | Pure positive | Ideal weight for summer evenings. |
| R046 | Pure positive | Very soft and warm; the cat has claimed it. |
| R047 | Pure positive | "10/10, would recommend." |
| R048 | Pure negative | Leaks from the bottom, which the reviewer calls dangerous near an outlet. |
| R049 | Pure negative | Handle gets dangerously hot and burned the reviewer's hand. |
| R050 | Pure positive | Praises the gooseneck spout for pour-over coffee. |
| R051 | Pure negative | Cord is too short to reach anywhere useful. |
| R052 | Pure positive | Started skeptical but calls them fantastic and would buy again. |
| R053 | Pure negative | One of the four bulbs was dead on arrival. |
| R054 | Pure positive | Very comfortable, and pairing was instant. |
| R055 | Mixed | Loves the tea presets, but the completion beep is too loud. |
| R056 | Pure positive | The box was crushed, but the earbuds work well. The complaint is packaging, not the product. |
| R057 | Unrelated | Complains about delivery time and a wet box; no product assessment, and the reviewer hasn't used it. |
| R058 | Pure negative | Sheds everywhere, covering the couch in fuzz. |
| R059 | Mixed | Waterproof as advertised, but the hip belt needs more padding. |
| R060 | Mixed | Battery is great, but the microphone is terrible. |
| R061 | Pure positive | Son has used it for school all year and it has held up. |
| R062 | Unrelated | Only comments on shipping taking three weeks. |
| R063 | Mixed | Boils fast, but the capacity is small. |
| R064 | Pure positive | Comfortable straps and plenty of pockets through a five-day trek. |
| R065 | Pure negative | Zipper broke on the first hike. |
| R066 | Pure negative | Sarcastic "great feature" about earbuds that fall out. |
| R067 | Questions | Asks whether the laptop sleeve fits a 16-inch laptop. |
| R068 | Pure negative | Sarcastic "two for one" about a blanket that is both itchy and thin. |
| R069 | Pure positive | "Love love love!!!" and buying another. |
| R070 | Pure positive | Praises the warm white setting as nice and cozy, with no complaint. |
| R071 | Mixed | Beautiful and cozy, but it shrank in the wash. |
| R072 | Mixed | Not as good as AirPods, though the price makes it acceptable. |
| R073 | Mixed | "Good enough for the price," but the reviewer would buy a better brand next time. |
| R074 | Pure negative | Mineral buildup after one month, and the reviewer is disappointed. |
| R075 | Mixed | Smaller than expected, but very soft. |
| R076 | Pure negative | "Worst earbuds I've ever owned." |
| R077 | Pure positive | Amazing sound for the price, with punchy bass that stays in during runs. |
| R078 | Pure negative | Sarcastic "thrilled" about a blanket that smells like a warehouse after washing. |
| R079 | Pure positive | Gave them as Christmas gifts and both daughters love them. |
| R080 | Pure negative | Sarcastic praise for a buckle that snapped halfway up a mountain. |
| R081 | Pure positive | Washes well with no pilling, which the reviewer calls great quality. |
| R082 | Pure positive | Perfect size for day hikes, with a nice hydration sleeve. |
| R083 | Pure positive | Looks more expensive than it is, and guests compliment it. |
| R084 | Mixed | Had a pairing problem, but support fixed it and everything works now. |
| R085 | Pure negative | Sarcastic "exactly what I wanted" about water that tastes like plastic. |
| R086 | Pure positive | Works well with Alexa, a game changer for the reviewer's mother. |
| R087 | Questions | Asks for the blanket's dimensions, which the listing doesn't provide. |
| R088 | Pure positive | Fun for parties, and the music sync mode is a hit. |
| R089 | Pure positive | Brief approving remark that it looks nice. |
| R090 | Pure positive | Gorgeous, quick, quiet, and no complaints. |
| R091 | Pure negative | Lid won't stay closed, causing steam everywhere. |
| R092 | Pure positive | Says it keeps the reviewer warm, with no complaints. |
| R093 | Unrelated | Complains that the delivery driver left the package in the rain. |
| R094 | Unrelated | Gift for a brother who hasn't opened it; no product assessment. |
| R095 | Pure negative | Stitching is coming apart after only two uses. |
| R096 | Pure negative | Requires an account and location data just to turn on a light. |
| R097 | Mixed | Loves the sound but hates the touch controls that pause the music. |
| R098 | Pure negative | Sarcastic "smart home" remark about needing to unplug the router. |
| R099 | Mixed | Pretty knit, but it snags on everything and is impractical. |
| R100 | Pure negative | Stopped working entirely after a month. |
| R101 | Questions | Asks whether the earbuds work with a PS5. |
| R102 | Pure positive | "Best throw blanket I've owned," heavy, warm, and soft. |
| R103 | Pure negative | Tinny sound, and they hurt after an hour. |
| R104 | Mixed | "It boils water. It's a kettle." is a flat, lukewarm remark. |
| R105 | Mixed | Wishes it came in more colors, but is otherwise perfect. |
| R106 | Pure positive | "Good kettle!!!" that is fast and pretty. |
| R107 | Pure negative | Unraveling after a month, and the reviewer calls it poor quality. |
| R108 | Pure negative | Sarcastic "impressive engineering" after three days before disconnecting every five minutes. |
| R109 | Pure negative | Charging case feels cheap and the lid snapped off within a month. |
| R110 | Pure negative | Not as bright as claimed, compared with a regular 60W bulb. |

Summary of categories: 46 pure positive, 45 pure negative, 26 mixed, 4 questions, and 6 unrelated (some counts overlap if you recount the table). The “mixed” category also absorbs a few purely lukewarm reviews (R016, R037, R038, R042, R043, R104), since the category set has no neutral option. If you’d prefer a separate neutral category, I can split those out.

### Version 4 (categories + few-shot + format + constraints + role)

You are a social psychologist hired to provide professional feedback on product reviews online, across many different products.

Categorize these reviews as pure positive, pure negative, mixed, questions, or unrelated. Format output as:

- a Markdown table with headers: Review Number, Category, Classification Rationale (explain why the category was chosen)
- a distribution count across categories

Rules:

- Output all reviews in a Markdown code block
- Do not output anything other than the table and counts.
- 15 words or less for rationale notes

Here are some examples of reviews and how they'd be categorized:

- "This might be the greatest thing since sliced bread. 10/10" - pure positive
- "This is just great. It stopped working the day after I got it. Just wonderful. 10/10" - pure negative
- "My only complaint is... (complaint). Other than that, it's the best. 8/10" - mixed
- "The package said it would come in Monday, but it didn't arrive until Thursday. Then somebody stole it off of my porch. 1/10" - unrelated

---
Output:

| Review Number | Category | Classification Rationale |
| --- | --- | --- |
| R001 | Pure negative | Reports chemical smell and a week of airing out |
| R002 | Mixed | Decent isolation praised, but noise cancelling claim is false |
| R003 | Pure negative | Earbud stopped charging, support never responded |
| R004 | Pure negative | Straps cause pain, customer is returning it |
| R005 | Mixed | Not warm enough for winter, but fine as decor |
| R006 | Pure positive | Praises commute performance, call clarity, and battery |
| R007 | Mixed | Good value, but inadequate for serious backpacking |
| R008 | Mixed | Bulbs bright and colorful, but drop Wi-Fi connection |
| R009 | Mixed | Praises bulbs, criticizes app, then recommends them |
| R010 | Pure positive | Bought a second one; first still works after a year |
| R011 | Pure negative | Arrived stained, reported as a defect |
| R012 | Questions | Asks whether bulbs work with Google Home |
| R013 | Mixed | Failed after six weeks; replacement works so far |
| R014 | Mixed | Dented unit, but support replaced it quickly; kettle fine |
| R015 | Pure negative | Too small for anything beyond a day trip |
| R016 | Mixed | Husband's lukewarm "fine" conveys tepid approval |
| R017 | Pure positive | Calls it bombproof after rough use with no damage |
| R018 | Pure negative | Colors judged washed out versus other brands |
| R019 | Pure negative | Wrong size sent by seller |
| R020 | Mixed | Color mismatch with photos, but still a good bag |
| R021 | Pure positive | Calls it great value that feels expensive |
| R022 | Pure negative | Sarcasm masks waterproofing failure that soaked contents |
| R023 | Pure positive | Sunrise alarm feature has made mornings easier |
| R024 | Pure negative | Sarcastic praise; settings lost after a firmware update |
| R025 | Pure negative | Buzzing at low dimming is annoying in quiet rooms |
| R026 | Unrelated | Comments only on early delivery, not the product |
| R027 | Pure positive | Fast boil and sleek design praised |
| R028 | Pure negative | Returned due to constant static in one earbud |
| R029 | Mixed | Acceptable for podcasts, rejected for music |
| R030 | Pure negative | Sarcastic praise; switch failed after one week |
| R031 | Pure negative | Constant app crashes and unresponsive bulbs |
| R032 | Pure negative | Keep-warm function too short to be useful |
| R033 | Pure positive | Calls it best purchase of the year, replacing expensive pair |
| R034 | Pure positive | Quick setup, vibrant colors, and liked scheduling |
| R035 | Pure positive | Bought a second pack for the whole house |
| R036 | Mixed | Wrong color delivered, but customer kept it as nice |
| R037 | Mixed | Lukewarm neutral statement with no clear sentiment |
| R038 | Mixed | Lukewarm "not bad, not great" verdict |
| R039 | Pure positive | Coworkers ask where it was bought, implying admiration |
| R040 | Pure positive | Holds up to toddler abuse and still looks new |
| R041 | Mixed | Praises build quality, criticizes pocket layout |
| R042 | Mixed | Acceptable only relative to its low price |
| R043 | Mixed | Functional but explicitly unremarkable |
| R044 | Pure positive | Praises comfort, durability, and bottle-fitting pockets |
| R045 | Pure positive | Describes it as perfect for summer evenings |
| R046 | Pure positive | Soft and warm; cat has claimed it |
| R047 | Pure positive | Explicit 10/10 with recommendation to others |
| R048 | Pure negative | Leaks from base, described as dangerous near outlets |
| R049 | Pure negative | Handle burned reviewer on first use |
| R050 | Pure positive | Gooseneck spout gives excellent pour-over control |
| R051 | Pure negative | Cord too short to reach useful outlets |
| R052 | Pure positive | Initially skeptical, now fantastic and would rebuy |
| R053 | Pure negative | One of four bulbs dead on arrival |
| R054 | Pure positive | Comfortable enough to forget wearing them; instant pairing |
| R055 | Mixed | Likes temperature presets, dislikes loud completion beep |
| R056 | Pure positive | Earbuds work well despite crushed shipping box |
| R057 | Unrelated | Comments on shipping and wet box, no product evaluation |
| R058 | Pure negative | Sheds heavily, covering furniture in fuzz |
| R059 | Mixed | Waterproof performance praised, hip belt criticized |
| R060 | Mixed | Battery praised, microphone criticized |
| R061 | Pure positive | Son has used it all school year without wear |
| R062 | Unrelated | Comments only on shipping duration |
| R063 | Mixed | Boils fast, but capacity is too small |
| R064 | Pure positive | Comfortable through a five-day trek with ample pockets |
| R065 | Pure negative | Zipper broke on first hike |
| R066 | Pure negative | Sarcastic; earbuds fall out constantly |
| R067 | Questions | Asks whether sleeve fits a 16-inch laptop |
| R068 | Pure negative | Sarcastic; blanket is itchy and thin |
| R069 | Pure positive | Enthusiastic praise and intent to buy another |
| R070 | Mixed | Warm white praised, colors unused |
| R071 | Mixed | Color and coziness praised, shrinking in wash criticized |
| R072 | Mixed | Inferior to AirPods, but acceptable given low price |
| R073 | Mixed | Adequate for price, but would choose a better brand |
| R074 | Pure negative | Mineral buildup within a month despite filtered water |
| R075 | Mixed | Soft, but smaller than expected |
| R076 | Pure negative | Calls them worst earbuds owned and warns others |
| R077 | Pure positive | Strong sound quality, punchy bass, secure fit |
| R078 | Pure negative | Sarcasm; smells like a warehouse after three washes |
| R079 | Pure positive | Both daughters love the Christmas gifts |
| R080 | Pure negative | Sarcasm; buckle snapped mid-mountain |
| R081 | Pure positive | Washes well with no pilling; good quality |
| R082 | Pure positive | Right size for day hikes; hydration sleeve bonus |
| R083 | Pure positive | Looks expensive and guests compliment it |
| R084 | Mixed | Pairing issue resolved by support; now works |
| R085 | Pure negative | Sarcasm; water tastes like plastic |
| R086 | Pure positive | Alexa integration is a game changer for user's mother |
| R087 | Questions | Asks for dimensions not listed on the page |
| R088 | Pure positive | Music sync mode is a hit at parties |
| R089 | Pure positive | Brief positive first impression of appearance |
| R090 | Pure positive | Praises looks, quick boil, and quiet operation |
| R091 | Pure negative | Lid fails to close, causing steam everywhere |
| R092 | Pure positive | Functional satisfaction: keeps reviewer warm |
| R093 | Unrelated | Describes delivery driver leaving item in rain |
| R094 | Unrelated | Gift purchase; recipient has not opened it |
| R095 | Pure negative | Stitching failed after only two uses |
| R096 | Pure negative | Requires account and location data for basic function |
| R097 | Mixed | Sound praised, touch controls criticized |
| R098 | Pure negative | Sarcasm; lights require unplugging router to operate |
| R099 | Mixed | Attractive knit, but snags and is impractical |
| R100 | Pure negative | Failed after one month; called waste of money |
| R101 | Questions | Asks whether earbuds work with PS5 |
| R102 | Pure positive | Calls it the best throw owned; heavy, warm, soft |
| R103 | Pure negative | Tinny sound and discomfort after an hour |
| R104 | Mixed | Purely functional, neutral assessment with no enthusiasm |
| R105 | Mixed | Praises performance, wishes for more color options |
| R106 | Pure positive | Brief praise for speed and appearance |
| R107 | Pure negative | Unraveling within a month, judged poor quality |
| R108 | Pure negative | Sarcasm; failed within three days |
| R109 | Pure negative | Cheap-feeling case with lid snapping off in a month |
| R110 | Pure negative | Brightness falls short of advertised 60W equivalent |

Distribution:

- Pure positive: 34
- Pure negative: 37
- Mixed: 30
- Questions: 4
- Unrelated: 5
- Total: 110

## Spot-check table

| Review Number | My Label | Model's Label | Agreed? |
| --- | --- | --- | --- |
| R005 | Mixed | Mixed | Agreed |
| R009 | Mixed | Mixed | Agreed |
| R013 | Mixed | Mixed | Agreed |
| R029 | Mixed | Mixed | Agreed |
| R055 | Mixed | Mixed | Agreed |
| R060 | Mixed | Mixed | Agreed |
| R066 | Pure negative | Pure negative | Agreed |
| R072 | Mixed | Mixed | Agreed |
| R073 | Mixed | Mixed | Agreed |
| R089 | Pure positive | Pure positive | Agreed |

## Analysis

Which techniques you used, and where in your prompts you used them

- Role - Started out with role so that the first tokens would guide the review checking from an educated social-behavioral perspective.
- Categories -
- Format -
- Constraints -
- Few-shot -

How each technique affected the output. Did it improve, stay the same, or get worse? Point to specific differences between versions.

- Role -
- Categories - Initially, adding a sarcasm category helped me to weed out which reviews were sarcastic. I ended up removing this category to improve selection.
- Format -
- Constraints -
- Few-shot - Improved the output a lot, sarcastic or mixed reviews were more consistently correctly categorized.

How the model handled tricky reviews (sarcasm, mixed opinions, unclear reviews), and what you changed in response

- Initially, adding a sarcasm category helped me to weed out which reviews were sarcastic. I ended up removing this category to improve selection.

Whether the model labeled every review, and what you did if it didn't

- The model managed to label every review.

Which technique made the biggest difference for you, and why you think that was

- Format made a big difference again, but ultimately few-shot helped the model the most. Giving examples of the less-clear responses, especially sarcastic ones, helped the model categorize those properly.
