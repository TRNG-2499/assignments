# Prompt Log
## Prompt Version 1
Are these reviews positive or negative?

## Output

The reviews are mixed overall, with a slight positive lean, but there are several recurring complaints about product quality, reliability, and customer experience.

I analyzed the 110 reviews across five products in your CSV file.

### Sentiment summary

Positive reviews

Praise for performance, value, comfort, and ease of use.

Negative reviews

Complaints about defects, poor durability, inaccurate descriptions, and frustrating apps.

Neutral or mixed reviews

Some products work adequately but have noticeable limitations.

### What customers are saying

| Product                   | Overall sentiment | Main takeaway                                                                          |
| ------------------------- | ----------------- | -------------------------------------------------------------------------------------- |
| Trailmark Hiking Backpack | Mixed             | Good value and durability for some users, but comfort and sizing issues                |
| Breeze Wireless Earbuds   | Mixed             | Good sound and battery life, offset by charging and connectivity problems              |
| Cozy Knit Throw Blanket   | Slightly positive | Softness and appearance are praised, but shedding and warmth are concerns              |
| Hearth Electric Kettle    | Mixed             | Fast boiling and attractive design, but some serious safety and reliability complaints |
| Lumen Smart Bulbs         | Mixed to negative | Bright colors and useful features, but app crashes and Wi-Fi disconnections            |

These product-level assessments are qualitative interpretations of the review text, not verified customer ratings.

### Examples from the reviews

Positive

“Boils water in under 3 minutes. Sleek design lo…”

Hearth Electric Kettle

Negative

“Left earbud stopped charging after two weeks. Contacted support and never heard back.”

Breeze Wireless Earbuds

Mixed

“Great bulbs, terrible app. If you can get past setup you'll love them.”

Lumen Smart Bulbs

Bottom line: The reviews are not uniformly positive or negative. Customers often like the products' core features, but recurring defects, software problems, and quality-control issues undermine satisfaction. The kettle reviews also contain potentially serious safety complaints that deserve particular attention.


## Analysis
The model summarized the reviews overall and by product category instead of labeling each individual review.It did not provide a structured list assigning a specific sentiment to every review ID, so you cannot sort or count the individual results. To handle reviews that were not strictly positive or negative, the model just grouped them into a "neutral or mixed" category. 



## Version 2
 Act as a Customer Insights Analyst for a retail company. Your task is to evaluate the sentiment of the reviews in the provided file. Please output your final results as a markdown table with exactly three columns: review_id, product, and sentiment.

I used role prompting by having it act as a customer insights analyst and output format was markdown with specific columns. The model managed to label all rows. 

### Output
| review_id | product                    | sentiment |
| --------- | -------------------------- | --------- |
| R001      | Trailmark Hiking Backpack  | Negative  |
| R002      | Breeze Wireless Earbuds    | Mixed     |
| R003      | Breeze Wireless Earbuds    | Negative  |
| R004      | Trailmark Hiking Backpack  | Negative  |
| R005      | Cozy Knit Throw Blanket    | Mixed     |
| R006      | Breeze Wireless Earbuds    | Positive  |
| R007      | Trailmark Hiking Backpack  | Positive  |
| R008      | Lumen Smart Bulbs (4-Pack) | Mixed     |
| R009      | Lumen Smart Bulbs (4-Pack) | Mixed     |
| R010      | Hearth Electric Kettle     | Positive  |
| R011      | Cozy Knit Throw Blanket    | Negative  |
| R012      | Lumen Smart Bulbs (4-Pack) | Neutral   |
| R013      | Hearth Electric Kettle     | Mixed     |
| R014      | Hearth Electric Kettle     | Mixed     |
| R015      | Trailmark Hiking Backpack  | Negative  |


## Version 3
Read the reviews in the file and label every single one. You must use exactly one of these four labels for each review:

- Positive: Expresses satisfaction or happiness.
- Negative: Expresses dissatisfaction, frustration, or safety concerns.
- Mixed: Contains both good and bad feedback.
- Neutral: Just asking a question or stating a fact without emotion.

In this one, I defined categories, and constraints. The model labeled all reviews with no extra descriptions and no tabular structure.

### Output
R001: Negative
R002: Mixed
R003: Negative
R004: Negative
R005: Mixed
R006: Positive
R007: Mixed
R008: Mixed
R009: Mixed
R010: Positive
R011: Negative
R012: Neutral
R013: Mixed
R014: Mixed
R015: Negative


## Version 4
Please classify the sentiment of each review in the provided file as Positive, Negative, Mixed, or Neutral. Here are a few examples of how you should handle tricky reviews:

- "wow so smart, it forgot all my settings after an update. genius." -> Negative(Handle sarcasm as negative)
- "Great bulbs, terrible app. If you can get past setup you'll love them." -> Mixed(Handle praise + complaint as mixed)
- "Do these work with Google Home or only Alexa?" -> Neutral(Handle questions as neutral)


This one is the best performing in my opinion. I used few-shot prompting by providing 3 specific examples on handling sarcasm, mixed opinion or questions. It managed to label all 110 reviews, and dropped it into a csv text, it also included the review text as well. 

review_id	product	review_text	sentiment
R001	Trailmark Hiking Backpack	Smells like chemicals out of the box. Took a week to air out.	Negative
R002	Breeze Wireless Earbuds	Noise isolation is decent, but it's not true noise cancelling like the description implies. Still good for the gym.	Mixed
R003	Breeze Wireless Earbuds	Left earbud stopped charging after two weeks. Contacted support and never heard back.	Negative
R004	Trailmark Hiking Backpack	Straps dig into my shoulders after an hour. Returning.	Negative
R005	Cozy Knit Throw Blanket	Not warm enough for winter. Fine as a decorative throw.	Negative
R006	Breeze Wireless Earbuds	Perfect for my commute. Clear calls, solid battery.	Positive
R007	Trailmark Hiking Backpack	decent bag for the money, not for serious backpacking tho	Mixed
R008	Lumen Smart Bulbs (4-Pack)	Bright and colorful, but they disconnect from Wi-Fi every few days.	Mixed
R009	Lumen Smart Bulbs (4-Pack)	Great bulbs, terrible app. If you can get past setup you'll love them.	Mixed
R010	Hearth Electric Kettle	Second one I've bought, gave the first to my mom. Still going strong after a year.	Positive
R011	Cozy Knit Throw Blanket	Arrived with a stain on it.	Negative
R012	Lumen Smart Bulbs (4-Pack)	Do these work with Google Home or only Alexa?	Neutral
R013	Hearth Electric Kettle	Stopped turning on after 6 weeks. Customer service sent a replacement, which works so far.	Mixed
**R014**	Hearth Electric Kettle	Mine arrived dented and customer service shipped a new one the next day. The kettle itself is fine.	Mixed


# Spot-Check Table
I used the version 3 since it's my best so far. 

|               |                                                                                  |              |                   |                                                                                                                                                                                                                                            |
| ------------- | -------------------------------------------------------------------------------- | ------------ | ----------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Review ID** | **Review Text Snippet**                                                          | **My Label** | **Model's Label** | **Agreement / Notes**                                                                                                                                                                                                                      |
| **R022**      | "Love that the waterproof pack turned my sleeping bag into a sponge. Ten stars." | Negative     | Negative          | **Agreed.** Handled sarcasm perfectly.                                                                                                                                                                                                     |
| **R012**      | "Do these work with Google Home or only Alexa?"                                  | Neutral      | Neutral           | **Agreed.** Recognized a simple question as neutral.                                                                                                                                                                                       |
| **R009**      | "Great bulbs, terrible app. If you can get past setup you'll love them."         | Mixed        | Mixed             | **Agreed.** Successfully balanced praise with a complaint.                                                                                                                                                                                 |
| **R056**      | "Box arrived crushed but the earbuds inside were fine. They work well."          | Positive     | Mixed             | **Disagreed.** I rated this Positive because the product itself was fine. The model rated it Mixed (likely due to the shipping complaint). A tighter definition in the prompt (e.g., "rate product only, ignore shipping") could fix this. |
| **R084**      | "Had a problem pairing, but support walked me through it in 10 minutes..."       | Positive     | Mixed             | **Disagreed.** I viewed a successfully resolved issue as Positive. The model flagged the initial problem as a negative element, making it Mixed.                                                                                           |
| **R104**      | "It boils water. It's a kettle."                                                 | Neutral      | Neutral           | **Agreed.** Handled a flat statement of fact correctly.                                                                                                                                                                                    |
| **R038**      | "they r ok i guess. not bad not great"                                           | Neutral      | Neutral           | **Agreed.** Captured mild ambivalence accurately.                                                                                                                                                                                          |
| **R105**      | "Wish it came in more colors. Otherwise perfect."                                | Mixed        | Mixed             | **Agreed.** The model noted the slight critique balancing the "perfect."                                                                                                                                                                   |
| **R066**      | "Absolutely love how they fall out every time I turn my head. Great feature."    | Negative     | Negative          | **Agreed.** Another perfect detection of sarcasm.                                                                                                                                                                                          |
| **R020**      | "Color is different from the photos... Still a good bag."                        | Mixed        | Mixed             | **Agreed.** Correctly identified the discrepancy complaint alongside the praise.                                                                                                                                                           |


# Analysis
- **Techniques Used & Placement:** I used Role Prompting and Output Formatting in Version 1 to force a structured table. I used Category Definitions and Negative Constraints in Version 2 to lock the model into four specific words and remove conversational filler. Finally, I used Few-Shot Prompting in Version 3 by providing direct examples of sarcasm and mixed reviews before giving it the dataset.

- **Effect on the output:**
Version 1 generated a highly readable markdown table, but lacked consistency on edge cases because "Mixed" and "Neutral" weren't clearly defined.

Version 2 also followed the constraint well. It stripped away all markdown tables and conversational text, leaving just a clean list that would be very easy to parse
Version 3 was the most contextually accurate. Even though I didn't strictly ask for a markdown table in V3, the model returned the data in a clean, tab-separated format with the original text included, making it incredibly easy to review.

- **Handling Tricky reviews:** Before I added definitions and few-shot examples, LLMs often struggle with whether to label a purely informative question (like R012) as positive or negative. The model easily handled sarcasm ("Ten stars" for a wet sleeping bag) in Version 3 because I specifically gave it an example of sarcastic praise equating to a Negative label. 
- **Completeness:** The model successfully labeled all 110 reviews across all three prompts. By explicitly asking it to output a list/table with IDs rather than asking "What is the sentiment?", it abandoned the summarization behavior entirely and processed the data line-by-line.
- **Biggest Difference Maker:** Few-Shot Prompting combined with defined categories made the biggest difference. While formatting techniques ensure the data looks pretty, few-shot prompting actually changes the quality of the model's logic. By showing it exactly how to classify a tricky review, it eliminated the guesswork and resulted in a more accurate, and easily sortable data.