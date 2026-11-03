<details><summary><strong>log</strong></summary>
  <details><summary><strong>Version 1 - Original</strong></summary>
    <details><summary><strong>Output</strong></summary>
The product-reviews.csv dataset contains 110 customer reviews spanning across five products (Trailmark Hiking Backpack, Breeze Wireless Earbuds, Cozy Knit Throw Blanket, Lumen Smart Bulbs (4-Pack), and Hearth Electric Kettle).

Rather than being entirely positive or entirely negative, the dataset contains a mixed distribution of sentiment across positive reviews, negative reviews (including heavy sarcastic complaints), mixed reviews, and neutral inquiries.

Sentiment Summary Breakdown
Positive Reviews (~36 / 110):

Express praise for product quality, performance, aesthetics, or customer service resolution.

Examples:

R010 (Hearth Electric Kettle): "Second one I've bought, gave the first to my mom. Still going strong after a year."

R017 (Trailmark Hiking Backpack): "Absolutely bombproof. Dragged it through brush, rocks, and rivers with zero damage."

R033 (Breeze Wireless Earbuds): "Best purchase I've made all year. My old $200 pair is collecting dust now."

R086 (Lumen Smart Bulbs): "Works perfectly with Alexa. Voice control is a game changer..."

Negative & Sarcastic Reviews (~41 / 110):

Highlight severe product failures (defects, breakage, connectivity dropouts, bad materials, or safety hazards), often expressed via direct criticism or strong sarcasm.

Examples:

R022 (Trailmark Hiking Backpack - Sarcastic): "Love that the "waterproof" pack turned my sleeping bag into a sponge. Ten stars."

R030 (Hearth Electric Kettle - Sarcastic): "Fantastic. Just fantastic. Mine lasted a full week before the switch broke."

R048 (Hearth Electric Kettle - Safety Hazard): "Leaks from the bottom. Dangerous near an electrical outlet."

R098 (Lumen Smart Bulbs - Sarcastic): "Nothing says "smart home" like having to unplug the router to turn on my lights."

Mixed Reviews (~24 / 110):

Feature balanced praise alongside specific trade-offs, moderate flaws, or conditional value.

Examples:

R002 (Breeze Wireless Earbuds): "Noise isolation is decent, but it's not true noise cancelling like the description implies. Still good for the gym."

R009 (Lumen Smart Bulbs): "Great bulbs, terrible app. If you can get past setup you'll love them."

R060 (Breeze Wireless Earbuds): "Battery life is great, easily 7 hours. Mic is terrible though..."

Neutral / Questions / Non-Review Comments (~9 / 110):

Include basic statements of function, unopened gifts, shipping/delivery issues unrelated to the product, or user questions.

Examples:

R012: "Do these work with Google Home or only Alexa?" (Product Question)

R037: "They're lightbulbs. They light up." (Indifferent Statement)

R094: "Bought these as a gift for my brother. He hasn't opened them yet." (Unopened Gift)
<details><summary><strong>Notes</strong></summary>
Read the output critically. 
- Did the model label each review or just summarize them?
  - summerized them with examples
- Could you sort or count the results? 
  - No Sort, it did count and cat 
- How did it handle reviews that aren't clearly positive or negative?
  - adds sarcastic with negitive
  - added a mixed review section
  - added a neutral / questions/ not review comments in a group
- cats are surprising correct   
      </details>
    </details>
  </details>
-------------------------------------------------------------------------------
  <details><summary><strong>Version 2 - Define the categories</strong></summary>
  Define the categories – Decide which labels the model should use and what each one means. Are two labels (positive/negative) enough, or do some reviews need another category?

  - Prompt - Are these reviews positive or negative? use these categories(positive, negative, mixed, neutral, question, other)
  - Result -

The dataset contains 110 reviews across multiple products. Using the requested categories (positive, negative, mixed, neutral, question, other), here is the breakdown and classification of the reviews.

### Summary of Category Counts

| Category | Count |
|---|---:|
| Positive | 36 |
| Negative | 37 |
| Mixed | 21 |
| Neutral | 12 |
| Question | 4 |
| Other | 0 |
| **Total** | **110** |

### Complete Classification List

| Review ID | Product | Review Text | Category |
|---|---|---|---|
| R001 | Trailmark Hiking Backpack | Smells like chemicals out of the box. Took a week to air out. | Negative |
| R002 | Breeze Wireless Earbuds | Noise isolation is decent, but it's not true noise cancelling like the description implies. Still good for the gym. | Mixed |
| R003 | Breeze Wireless Earbuds | Left earbud stopped charging after two weeks. Contacted support and never heard back. | Negative |
| R004 | Trailmark Hiking Backpack | Straps dig into my shoulders after an hour. Returning. | Negative |
| R005 | Cozy Knit Throw Blanket | Not warm enough for winter. Fine as a decorative throw. | Mixed |
| R006 | Breeze Wireless Earbuds | Perfect for my commute. Clear calls, solid battery. | Positive |
| R007 | Trailmark Hiking Backpack | decent bag for the money, not for serious backpacking tho | Mixed |
| R008 | Lumina Smart Light Bulb | Bright and colorful, but they disconnect from Wi-Fi every few days. | Mixed |
| R009 | Lumina Smart Light Bulb | Great bulbs, terrible app. If you can get past setup you'll love them. | Mixed |
| R010 | Breeze Wireless Earbuds | Second one I've bought, gave the first to my mom. Still going strong after a year. | Positive |
| R011 | Cozy Knit Throw Blanket | Arrived with a stain on it. | Negative |
| R012 | Lumina Smart Light Bulb | Do these work with Google Home or only Alexa? | Question |
| R013 | Lumina Smart Light Bulb | Stopped turning on after 6 weeks. Customer service sent a replacement, which works so far. | Mixed |
| R014 | AeroVolt Electric Kettle | Mine arrived dented and customer service shipped a new one the next day. The kettle itself is fine. | Mixed |
| R015 | Trailmark Hiking Backpack | Way too small for anything over a day trip despite what the listing says. | Negative |

  </details>
  -------------------------------------------------------------------------------
  <details><summary><strong>Version 3 -  Few-shot prompting</strong></summary>
  Few-shot prompting – Give the model a few example reviews along with the label you would assign to each. Examples are most helpful for tricky cases, like sarcasm or reviews that praise one thing and complain about another.
  - Prompt - Are these reviews positive or negative? Use these 5 examples to help sort the reviews:  
    "I love this product, works great." = positive  
    "Broke after a week, waste of money." = negative  
    "Works great and was worth the money." = positive  
    "Battery doesn't last long, wouldn't buy again." = negative  
    "Great, broke after using it one time." = negative  
  - Results - 

<details>
<summary><strong>Output</strong></summary>

<br>

Here is the sentiment classification for the product reviews in `product-reviews.csv`, evaluated against your 5 benchmark examples (accounting for direct praise, product flaws/defects, sarcastic/ironic negative feedback, and neutral/inquiry statements).

### Summary Overview

| Sentiment Category | Total Count | Description |
|---|---:|---|
| Positive | 49 | Expresses satisfaction, good performance, or great value. |
| Negative | 47 | Product defect, broken component, poor quality, or sarcastic dissatisfaction. |
| Neutral / Inquiry | 14 | Questions, factual statements without clear sentiment, or unopened gifts. |

### Complete Review Classification

| Review ID | Product | Review Text | Sentiment |
|---|---|---|---|
| R001 | Trailmark Hiking Backpack | Smells like chemicals out of the box. Took a week to air out. | Negative |
| R002 | Breeze Wireless Earbuds | Noise isolation is decent, but it's not true noise cancelling... Still good for the gym. | Positive |
| R003 | Breeze Wireless Earbuds | Left earbud stopped charging after two weeks. Contacted support and never heard back. | Negative |
| R004 | Trailmark Hiking Backpack | Straps dig into my shoulders after an hour. Returning. | Negative |
| R005 | Cozy Knit Throw Blanket | Not warm enough for winter. Fine as a decorative throw. | Negative |
| R006 | Breeze Wireless Earbuds | Perfect for my commute. Clear calls, solid battery. | Positive |
| R007 | Trailmark Hiking Backpack | decent bag for the money, not for serious backpacking tho | Positive |
| R008 | Lumen Smart Bulbs (4-Pack) | Bright and colorful, but they disconnect from Wi-Fi every few days. | Negative |
| R009 | Lumen Smart Bulbs (4-Pack) | Great bulbs, terrible app. If you can get past setup you'll love them. | Positive |
| R010 | Hearth Electric Kettle | Second one I've bought, gave the first to my mom. Still going strong after a year. | Positive |
| R011 | Cozy Knit Throw Blanket | Arrived with a stain on it. | Negative |
| R012 | Lumen Smart Bulbs (4-Pack) | Do these work with Google Home or only Alexa? | Neutral |
| R013 | Hearth Electric Kettle | Stopped turning on after 6 weeks. Customer service sent a replacement, which works so far. | Positive |
| R014 | Hearth Electric Kettle | Mine arrived dented and customer service shipped a new one the next day. The kettle itself is fine. | Positive |
| R015 | Trailmark Hiking Backpack | Way too small for anything over a day trip despite what the listing says. | Negative |

<br>

</details>

  
  </details>
-------------------------------------------------------------------------------
  <details><summary><strong>Version 4 - Output format</strong></summary>
  Output format – Specify exactly how the results should be structured (for example, a table with specific columns) so you could paste them into a spreadsheet.

- prompt - Rate each review in the file based on how positive or negative it is. Use a percentage from 0% to 100%, where 0% is completely negative and 100% is completely positive.  
Put the results in a table with these columns:  
Review ID | Product | Review | Rating %

- result - 

Here is the rating for each review in the file, evaluated on a scale from 0% (completely negative) to 100% (completely positive) based on sentiment, customer experience, tone (including sarcasm), and overall rating implicit in the feedback.

### Review Sentiment Ratings

| Review ID | Product | Review | Rating % |
|---|---|---|---:|
| R001 | Trailmark Hiking Backpack | Smells like chemicals out of the box. Took a week to air out. | 25% |
| R002 | Breeze Wireless Earbuds | Noise isolation is decent, but it's not true noise cancelling like the description implies. Still good for the gym. | 60% |
| R003 | Breeze Wireless Earbuds | Left earbud stopped charging after two weeks. Contacted support and never heard back. | 5% |
| R004 | Trailmark Hiking Backpack | Straps dig into my shoulders after an hour. Returning. | 10% |
| R005 | Cozy Knit Throw Blanket | Not warm enough for winter. Fine as a decorative throw. | 45% |
| R006 | Breeze Wireless Earbuds | Perfect for my commute. Clear calls, solid battery. | 100% |
| R007 | Trailmark Hiking Backpack | decent bag for the money, not for serious backpacking tho | 55% |
| R008 | Lumen Smart Bulbs (4-Pack) | Bright and colorful, but they disconnect from Wi-Fi every few days. | 40% |
| R009 | Lumen Smart Bulbs (4-Pack) | Great bulbs, terrible app. If you can get past setup you'll love them. | 65% |
| R010 | Hearth Electric Kettle | Second one I've bought, gave the first to my mom. Still going strong after a year. | 100% |
| R011 | Cozy Knit Throw Blanket | Arrived with a stain on it. | 10% |
| R012 | Lumen Smart Bulbs (4-Pack) | Do these work with Google Home or only Alexa? | 50% |
| R013 | Hearth Electric Kettle | Stopped turning on after 6 weeks. Customer service sent a replacement, which works so far. | 50% |
| R014 | Hearth Electric Kettle | Mine arrived dented and customer service shipped a new one the next day. The kettle itself is fine. | 65% |
| R015 | Trailmark Hiking Backpack | Way too small for anything over a day trip despite what the listing says. | 20% |



  </details>
-------------------------------------------------------------------------------
  <details><summary><strong>Version 5 - Constraints</strong></summary>
    
  Constraints – Add rules, such as how long any explanation can be, what to do if a review is unclear, or that every review must receive exactly one label.  
  - prompt - Are these reviews positive or negative? Follow these rules when sorting the reviews:  
  Every review must be labeled positive or negative.  
  If a review has both positive and negative opinions, choose whichever is stronger.  
  If a review is unclear, make your best guess.  
  Only give the first 15 results.
  - results -  

Here are the classifications for the first 15 reviews, sorted into positive and negative labels based on sentiment strength:

### Review Sentiment Classification

| Review ID | Product | Review Text | Classification |
|---|---|---|---|
| R001 | Trailmark Hiking Backpack | Smells like chemicals out of the box. Took a week to air out. | Negative |
| R002 | Breeze Wireless Earbuds | Noise isolation is decent, but it's not true noise cancelling like the description implies. Still good for the gym. | Positive |
| R003 | Breeze Wireless Earbuds | Left earbud stopped charging after two weeks. Contacted support and never heard back. | Negative |
| R004 | Trailmark Hiking Backpack | Straps dig into my shoulders after an hour. Returning. | Negative |
| R005 | Cozy Knit Throw Blanket | Not warm enough for winter. Fine as a decorative throw. | Negative |
| R006 | Breeze Wireless Earbuds | Perfect for my commute. Clear calls, solid battery. | Positive |
| R007 | Trailmark Hiking Backpack | decent bag for the money, not for serious backpacking tho | Positive |
| R008 | Lumen Smart Bulbs (4-Pack) | Bright and colorful, but they disconnect from Wi-Fi every few days. | Negative |
| R009 | Lumen Smart Bulbs (4-Pack) | Great bulbs, terrible app. If you can get past setup you'll love them. | Positive |
| R010 | Hearth Electric Kettle | Second one I've bought, gave the first to my mom. Still going strong after a year. | Positive |
| R011 | Cozy Knit Throw Blanket | Arrived with a stain on it. | Negative |
| R012 | Lumen Smart Bulbs (4-Pack) | Do these work with Google Home or only Alexa? | Negative |
| R013 | Hearth Electric Kettle | Stopped turning on after 6 weeks. Customer service sent a replacement, which works so far. | Positive |
| R014 | Hearth Electric Kettle | Mine arrived dented and customer service shipped a new one the next day. The kettle itself is fine. | Positive |
| R015 | Trailmark Hiking Backpack | Way too small for anything over a day trip despite what the listing says. | Negative |

  
  </details>
-------------------------------------------------------------------------------
  <details><summary><strong>Version 6 - Role prompting</strong></summary>  
  Role prompting – Tell the model who it is (for example, someone who analyzes customer feedback for a company) before giving it the task.  
    
- prompt - Are these reviews positive or negative? You are a customer looking at reviews of a brand to see if it is reliable and worth buying from.  
    
- result -

# Overall Assessment: Is This Brand Worth Buying From?

**Verdict: Proceed with extreme caution (or look elsewhere).** The brand shows significant reliability and quality control red flags.

While the products have moments of quality when they work properly, the overall dataset leans negative to mixed. Out of the 110 reviews across 4 product lines:

- **~41% Negative:** Including severe product failures, defect issues, and sarcastic complaints.
- **~20% Mixed:** Customers like one aspect, such as price or design, but highlight major trade-offs or usability flaws.
- **~29% Positive:** Customers are satisfied with their purchases.
- **~10% Neutral:** Inquiries, factual statements, or unopened gifts.

## Detailed Breakdown by Product Line

### 1. 🫖 Hearth Electric Kettle (Mixed to Dangerous)

**The Good:**
- Boils water fast.
- Attractive design.
- Good gooseneck flow for pour-over coffee.

**The Dealbreakers:**

**Safety Hazards:**
- Multiple buyers reported leaks near the electrical base.
- Handles get hot enough to burn hands.

**Reliability:**
- Switches breaking within a week to 6 weeks.
- Steam leaks from loose lids.
- Plastic taste in water.
- Rapid mineral buildup.

### 2. 🎧 Breeze Wireless Earbuds (Mostly Negative)

**The Good:**
- Decent option for casual gym use or podcasts given the lower price tag.
- Punchy bass when fitting well.

**The Dealbreakers:**

**Build Quality & Hardware Failures:**
- Frequent charging case breakage.
- Dead or non-charging earbuds within days to weeks.
- Bad microphones ("sounds like underwater").
- Constant Bluetooth disconnections.

**Customer Service:**
- Buyers reported ignored support requests when seeking replacements for defective units.

### 3. 💡 Lumen Smart Bulbs 4-Pack (Mixed / Software Bottlenecked)

**The Good:**
- Vibrant colors.
- Easy hardware setup.
- Nice sunrise and scheduling features when functioning.

**The Dealbreakers:**

**Connectivity & Software:**
- Bulbs frequently drop from Wi-Fi.
- App crashes.
- Settings reset after firmware updates.
- Privacy-heavy app permissions requiring location data.

**Hardware Defects:**
- Dead-on-arrival bulbs.
- Low-frequency buzzing when dimmed below 30%.
- Lower brightness than advertised.

### 4. 🎒 Trailmark Hiking Backpack (Mixed to Fragile)

**The Good:**
- Highly rated by casual day-hikers for price, comfort, and organization when intact.

**The Dealbreakers:**

**Quality Control & Durability:**
- Snapped buckles mid-hike.
- Broken zippers on first use.
- Stitching unraveling after two uses.
- Leaking despite advertised "waterproofing."

**Sizing/Listing Issues:**
- Product dimensions are misleading compared to listing descriptions.

## Key Buyer Red Flags to Note

**1. High Rate of Heavy Sarcasm**
- Several 5-star style phrases are actually sarcastic complaints about failed waterproofing, snapped buckles, plastic taste, and broken switches within days of purchase.

**2. Poor Quality Control (QC)**
- A high percentage of items arrive damaged, with wrong colors/sizes, stains, or dead on arrival (DOA).

**3. Safety Risks**
- Critical electrical and thermal warnings on the electric kettle indicate inadequate product testing.

**4. Customer Support Inconsistency**
- While some buyers received prompt replacements, others were ignored completely when attempting to claim warranties.

## Final Recommendation

If you decide to purchase, stick to low-risk aesthetic items like the **Cozy Knit Throw Blanket** (though expect potential shedding/shrinking) or **Trailmark Hiking Backpack** for light casual use only.

**Avoid their electronics (earbuds, kettle, smart bulbs)**, as the failure rate within the first month is disproportionately high.
  </details>
</details>


<details><summary><strong>Spot-check table </strong></summary>
  Spot-check table – Your 10 hand-labeled reviews, showing the review ID, your label, the model's label, and whether you agreed.  

| Review ID | My Label | Version 1 | Version 2 | Version 3 | Version 4 | Version 5 | Version 6 |
|---|---|---|---|---|---|---|---|
| R014 | Negative | N/A | Mixed | Positive | 65% | Positive | N/A |
| R015 | Negative | N/A | Negative | Negative | 20% | Negative | N/A |
| R012 | Other | Question | Question | Neutral | 50% | Negative | N/A |
| R008 | Negative | N/A | Mixed | Negative | 40% | Negative | N/A |
| R004 | Negative | N/A | Negative | Negative | 10% | Negative | N/A |
| R006 | Positive | N/A | Positive | Positive | 100% | Positive | N/A |
| R005 | Positive | N/A | Mixed | Negative | 45% | Negative | N/A |
| R001 | Negative | N/A | Negative | Negative | 25% | Negative | N/A |
| R010 | Positive | Positive | Positive | Positive | 100% | Positive | N/A |
| R013 | Negative | N/A | Mixed | Positive | 50% | Positive | N/A |

</details>

<details><summary><strong>Analysis</strong></summary>
Analysis – A brief reflection (a few short paragraphs or bullet points) covering:

Which techniques you used, and where in your prompts you used them
- I used category definitions in Version 2, few shot prompting in Version 3, and output formatting in Version 4.
- Version 5 used constraints, and Version 6 used role prompting to have the AI act as a customer checking if a brand was reliable.
  
How each technique affected the output. Did it improve, stay the same, or get worse? Point to specific differences between versions.
- Version 2 was a big improvement over Version 1. Instead of just summarizing the reviews, it sorted them into categories. Version 3 had similar results but handled mixed reviews differently.
- Version 4 gave percentage ratings, Version 5 followed the 15 review limit, and Version 6 focused on whether the brand was worth buying from instead of sorting reviews.
  
How the model handled tricky reviews (sarcasm, mixed opinions, unclear reviews), and what you changed in response
- The AI handled sarcasm pretty well, but mixed reviews were inconsistent. R008 was Mixed in Version 2 but Negative in Versions 3 and 5.
- Questions were also an issue. R012 was labeled Question, Neutral, and Negative across different versions. I tried examples and constraints, but the results still varied.
  
Whether the model labeled every review, and what you did if it didn't
- Version 1 and Version 6 only gave summaries. Versions 2 and 3 reported results for all 110 reviews, but I only saved the first 15.
- Version 4 also had 15 results saved, and Version 5 only gave 15 because I specifically asked it to.
  
Which technique made the biggest difference for you, and why you think that was
- I think adding categories in Version 2 made the biggest difference because it changed the results from a summary into an actual table.
- Role prompting also made a big difference, but it changed the focus of the task instead of improving how the reviews were sorted.
</details>
