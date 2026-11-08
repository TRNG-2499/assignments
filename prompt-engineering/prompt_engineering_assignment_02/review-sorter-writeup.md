# Customer Review Sorter

**Name:** Ethan Surati

**How the prompts were run:** Each version was run in a fresh Claude session (a separate Claude Code subagent) with only `product-reviews.csv` and that version's prompt. Each run was told to answer as a normal chat reply without writing or running code, and to save its reply to a file. The prompts below are exactly what each run received.

---

## Prompt Log

### Version 1

**Techniques used:** None (baseline)

**Prompt:**

```text
Are these reviews positive or negative?
```

**Output:**

> They're a mix. Overall the reviews split almost evenly between positive and negative, with no clear lean either way. I read all 110 and sorted them like this:
>
> | Sentiment | Count | Share |
> |---|---|---|
> | Positive | 36 | 33% |
> | Negative | 37 | 34% |
> | Mixed (real praise and real complaints) | 20 | 18% |
> | Neutral / not a product opinion | 17 | 15% |
>
> **By product**
>
> | Product | Positive | Negative | Mixed | Neutral |
> |---|---|---|---|---|
> | Trailmark Hiking Backpack | 7 | 8 | 4 | 3 |
> | Breeze Wireless Earbuds | 7 | 7 | 4 | 4 |
> | Cozy Knit Throw Blanket | 8 | 5 | 5 | 4 |
> | Lumen Smart Bulbs (4-Pack) | 7 | 9 | 3 | 3 |
> | Hearth Electric Kettle | 7 | 8 | 4 | 3 |
>
> The blanket comes out best and the smart bulbs come out worst, but the gaps are small. No product is clearly loved or clearly hated.
>
> **Things worth knowing about how I counted**
>
> - **Sarcasm.** About 10 reviews sound positive but are actually complaints, so I counted them as negative. For example, "Love that the 'waterproof' pack turned my sleeping bag into a sponge. Ten stars." (R022) and "Fantastic. Just fantastic. Mine lasted a full week before the switch broke." (R030). Others: R024, R066, R068, R078, R080, R085, R098, R108. A simple keyword-based tool would likely count these as positive.
> - **Neutral covers a few kinds of entries:**
>   - Questions, not reviews: R012, R067, R087, R101
>   - Only about shipping or delivery, not the product: R026, R057, R062, R093
>   - Too early to judge: R089, R094
>   - Lukewarm "it's fine": R016, R037, R038, R042, R043, R092, R104
> - **Mixed reviews** usually praise the product and name one specific flaw, like "Great bulbs, terrible app" (R009) or great battery but a bad mic (R060). A few lean one way. R020, R036 and R059 are mostly positive, and R005 and R099 are mostly negative. Some judgment calls could go either way, so another reader might be off by a few in each bucket.
>
> **Recurring themes**
>
> - **Praise:** comfort and durability (backpack, blanket), sound for the price (earbuds), fast boiling and good looks (kettle), easy setup and fun features (bulbs).
> - **Complaints:** parts breaking early (zippers, buckles, stitching, charging cases, kettle switches), smart bulb connectivity and app problems, and products not matching the listing (size, color, brightness, "waterproof").
> - **Safety flags on the kettle:** one review says it leaks near the outlet (R048) and another says the handle burned their hand (R049). Those two are worth following up on separately.
>
> If you'd like, I can list every review with its label so you can check my calls, or dig into one product.

*Note: the model did not label individual reviews. It returned a summary with counts, so the results can't be sorted or checked review by review.*

### Version 2

**Techniques used:** Defined categories

**Prompt:**

```text
Label each review in the attached file with exactly one of these:
- Positive: the customer is happy overall
- Negative: the customer is unhappy overall
- Mixed: the review has clear praise AND a clear complaint
- Unclear: not enough information to tell
```

**Output:**

> Here are the labels for all 110 reviews.
>
> | ID | Product | Label |
> |---|---|---|
> | R001 | Trailmark Hiking Backpack | Negative |
> | R002 | Breeze Wireless Earbuds | Mixed |
> | R003 | Breeze Wireless Earbuds | Negative |
> | R004 | Trailmark Hiking Backpack | Negative |
> | R005 | Cozy Knit Throw Blanket | Negative |
> | R006 | Breeze Wireless Earbuds | Positive |
> | R007 | Trailmark Hiking Backpack | Mixed |
> | R008 | Lumen Smart Bulbs (4-Pack) | Mixed |
> | R009 | Lumen Smart Bulbs (4-Pack) | Mixed |
> | R010 | Hearth Electric Kettle | Positive |
> | R011 | Cozy Knit Throw Blanket | Negative |
> | R012 | Lumen Smart Bulbs (4-Pack) | Unclear |
> | R013 | Hearth Electric Kettle | Mixed |
> | R014 | Hearth Electric Kettle | Positive |
> | R015 | Trailmark Hiking Backpack | Negative |
> | R016 | Trailmark Hiking Backpack | Unclear |
> | R017 | Trailmark Hiking Backpack | Positive |
> | R018 | Lumen Smart Bulbs (4-Pack) | Negative |
> | R019 | Trailmark Hiking Backpack | Negative |
> | R020 | Trailmark Hiking Backpack | Mixed |
>
> *[Rows R021–R110 omitted]*
>
>
> **Totals:** 38 Positive, 40 Negative, 18 Mixed, 14 Unclear
>
> **Judgment calls worth knowing about:**
>
> - **Sarcasm:** R022, R024, R030, R066, R068, R078, R080, R085, R098 and R108 use positive words ("Ten stars," "genius," "Great feature") to complain, so they're all labeled Negative.
> - **Lukewarm or neutral reviews:** R037, R038, R042, R043, R092 and R104 ("It's fine," "They light up," "Ok for the price") don't show the customer as clearly happy or unhappy, and they don't have real praise plus a real complaint. Since there's no Neutral option, I put them under Unclear. If you'd rather count "it's fine" as mildly Positive, those are the ones to flip.
> - **Questions and non-reviews:** R012, R067, R087 and R101 are pre-purchase questions. R016, R057 and R094 are secondhand or not-yet-used. All are Unclear.
> - **Shipping and delivery comments:** R062 (3-week shipping) and R093 (left in the rain) are clear complaints, so they're Negative. R026 ("arrived a day early") says nothing about the product or how the customer feels about it, so it's Unclear.
> - **Problem fixed by support:** R014 and R084 had an issue that was resolved, and the customer sounds satisfied, so they're Positive. R013 is Mixed because the product itself failed and the replacement has only worked "so far."
> - **Weak praise next to a complaint:** R005 ("Not warm enough for winter. Fine as a decorative throw.") is Negative because "fine" isn't real praise. R007, R029 and R073 pair real (if modest) praise with a clear limitation, so they're Mixed.

*Note: all 110 of 110 reviews were labeled. Counts: Positive 38, Negative 40, Mixed 18, Unclear 14.*

### Version 3

**Techniques used:** Defined categories + output format

**Prompt:**

```text
Label each review in the attached file with exactly one of these:
- Positive: the customer is happy overall
- Negative: the customer is unhappy overall
- Mixed: the review has clear praise AND a clear complaint
- Unclear: not enough information to tell

Return a table with these columns: Review ID, Product, Sentiment, Reason.
Include every review in the file, in the same order.
```

**Output:**

> | Review ID | Product | Sentiment | Reason |
> |---|---|---|---|
> | R001 | Trailmark Hiking Backpack | Negative | Strong chemical smell that took a week to air out |
> | R002 | Breeze Wireless Earbuds | Mixed | Says the description oversells the noise cancelling, but still good for the gym |
> | R003 | Breeze Wireless Earbuds | Negative | Left earbud stopped charging and support never replied |
> | R004 | Trailmark Hiking Backpack | Negative | Straps are uncomfortable; returning it |
> | R005 | Cozy Knit Throw Blanket | Mixed | Not warm enough for winter, though fine as a decorative throw |
> | R006 | Breeze Wireless Earbuds | Positive | Clear calls and solid battery; works well for commuting |
> | R007 | Trailmark Hiking Backpack | Mixed | Decent for the money, but not suitable for serious backpacking |
> | R008 | Lumen Smart Bulbs (4-Pack) | Mixed | Bright and colorful, but they keep dropping off Wi-Fi |
> | R009 | Lumen Smart Bulbs (4-Pack) | Mixed | Loves the bulbs, hates the app and setup |
> | R010 | Hearth Electric Kettle | Positive | Repeat buyer; first one still working after a year |
> | R011 | Cozy Knit Throw Blanket | Negative | Arrived stained |
> | R012 | Lumen Smart Bulbs (4-Pack) | Unclear | A compatibility question, not a review |
> | R013 | Hearth Electric Kettle | Mixed | Died after 6 weeks; support sent a replacement that works so far |
> | R014 | Hearth Electric Kettle | Positive | Arrived dented, but support replaced it the next day and the kettle is fine |
> | R015 | Trailmark Hiking Backpack | Negative | Much smaller than the listing suggests |
> | R016 | Trailmark Hiking Backpack | Unclear | Secondhand "fine" with no detail; tone can't be judged |
> | R017 | Trailmark Hiking Backpack | Positive | Extremely durable under rough use |
> | R018 | Lumen Smart Bulbs (4-Pack) | Negative | Colors look washed out compared to other brands |
> | R019 | Trailmark Hiking Backpack | Negative | Seller sent the wrong size |
> | R020 | Trailmark Hiking Backpack | Mixed | Color doesn't match the photos, but still a good bag |
>
> *[Rows R021–R110 omitted]*
>
>
> **Totals (110 reviews):** Positive 38, Negative 37, Mixed 19, Unclear 16
>
> A few judgment calls to know about:
>
> - **Sarcasm:** Reviews like R022, R030, R066, and R085 use positive words to complain, so I labeled them Negative.
> - **Neutral reviews:** There's no Neutral option, so flat, lukewarm reviews ("It's fine," "not bad not great," "It's a kettle") went under Unclear. If you'd rather call those Mixed or mildly Positive, R037, R038, R042, R043, R092, and R104 are the ones to change.
> - **Delivery-only and non-reviews:** Reviews about shipping alone (R026, R057, R062, R093), questions (R012, R067, R087, R101), and unopened gifts (R094) are Unclear because they say nothing about the product itself.
> - **Problems that got fixed:** When support fully fixed a minor issue, I went with the customer's overall happiness and labeled it Positive (R014, R084). When the product itself broke, I labeled it Mixed even though it was replaced (R013).

*Note: all 110 of 110 reviews were labeled. Counts: Positive 38, Negative 37, Mixed 19, Unclear 16.*

### Version 4

**Techniques used:** Defined categories + output format + few-shot examples

**Prompt:**

```text
Label each review in the attached file with exactly one of these:
- Positive: the customer is happy overall
- Negative: the customer is unhappy overall
- Mixed: the review has clear praise AND a clear complaint
- Unclear: not enough information to tell

Return a table with these columns: Review ID, Product, Sentiment, Reason.
Include every review in the file, in the same order.

Examples:
"Charges fast and the battery lasts all week." -> Positive
"Wow, broke on day two. Truly amazing quality." -> Negative (sarcasm)
"Looks great, but the strap snapped after a month." -> Mixed
"Got it yesterday, haven't used it yet." -> Unclear
```

**Output:**

> | Review ID | Product | Sentiment | Reason |
> |---|---|---|---|
> | R001 | Trailmark Hiking Backpack | Negative | Strong chemical smell out of the box that took a week to air out |
> | R002 | Breeze Wireless Earbuds | Mixed | Says it isn't true noise cancelling as described, but still good for the gym |
> | R003 | Breeze Wireless Earbuds | Negative | Left earbud stopped charging and support never replied |
> | R004 | Trailmark Hiking Backpack | Negative | Uncomfortable straps; returning it |
> | R005 | Cozy Knit Throw Blanket | Mixed | Not warm enough for winter, though fine as a decorative throw |
> | R006 | Breeze Wireless Earbuds | Positive | Great for commuting, with clear calls and solid battery |
> | R007 | Trailmark Hiking Backpack | Mixed | Decent for the money, but not good enough for serious backpacking |
> | R008 | Lumen Smart Bulbs (4-Pack) | Mixed | Bright and colorful, but drops off Wi-Fi every few days |
> | R009 | Lumen Smart Bulbs (4-Pack) | Mixed | Loves the bulbs, hates the app and setup |
> | R010 | Hearth Electric Kettle | Positive | Bought a second one; still going strong after a year |
> | R011 | Cozy Knit Throw Blanket | Negative | Arrived stained |
> | R012 | Lumen Smart Bulbs (4-Pack) | Unclear | Compatibility question, no opinion given |
> | R013 | Hearth Electric Kettle | Mixed | Stopped working after 6 weeks; the replacement works so far |
> | R014 | Hearth Electric Kettle | Positive | Arrived dented, but it was replaced the next day and the kettle is fine |
> | R015 | Trailmark Hiking Backpack | Negative | Much smaller than the listing suggests |
> | R016 | Trailmark Hiking Backpack | Unclear | Secondhand "fine" in quotes; could be lukewarm or sarcastic |
> | R017 | Trailmark Hiking Backpack | Positive | Extremely durable on rough terrain |
> | R018 | Lumen Smart Bulbs (4-Pack) | Negative | Colors look washed out compared to other brands |
> | R019 | Trailmark Hiking Backpack | Negative | Seller sent the wrong size |
> | R020 | Trailmark Hiking Backpack | Mixed | Color doesn't match the photos, but still a good bag |
>
> *[Rows R021–R110 omitted]*
>
>
> A few calls you may want to check:
>
> - **Neutral reviews** (R037, R038, R042, R043, R092, R104): Your four labels don't include a Neutral option. These reviews give enough to judge, but they don't lean either way, so I put them under Unclear. If you'd rather keep Unclear for reviews with too little information, you may want to add a Neutral label.
> - **Lukewarm praise plus a limitation** (R005, R007, R029, R073): I called these Mixed. You could also read them as mildly Negative (R005, R073) or mildly Positive (R007).
> - **Problem fixed by support** (R014, R084 vs. R013): When the issue was minor and the customer ended up satisfied, I labeled it Positive. R013 is Mixed because the product itself stopped working, even though the replacement works.
> - **Delivery-only reviews**: Clear complaints with nothing positive (R019, R062, R093) are Negative. R026 states a neutral fact, and R057 hasn't used the product yet, so both are Unclear.
> - **R016 and R089**: I labeled these Unclear because they're secondhand or only a first impression. R089 ("looks nice") could fairly be called Positive.

*Note: all 110 of 110 reviews were labeled. Counts: Positive 37, Negative 39, Mixed 19, Unclear 15.*

### Version 5

**Techniques used:** Role + defined categories + output format + few-shot examples + constraints

**Prompt:**

```text
You analyze customer feedback for an online retailer.

Label each review in the attached file with exactly one of these:
- Positive: the customer is happy overall
- Negative: the customer is unhappy overall
- Mixed: the review has clear praise AND a clear complaint
- Unclear: not enough information to tell

Return a table with these columns: Review ID, Product, Sentiment, Reason.
Include every review in the file, in the same order.

Examples:
"Charges fast and the battery lasts all week." -> Positive
"Wow, broke on day two. Truly amazing quality." -> Negative (sarcasm)
"Looks great, but the strap snapped after a month." -> Mixed
"Got it yesterday, haven't used it yet." -> Unclear

Rules:
- Every review gets exactly one label. Do not skip or summarize any.
- Keep each reason under 10 words.
- Sarcasm counts as what the customer actually means, not the literal words.
- At the end, write "Labeled X of Y reviews" and give a count for each label.
```

**Output:**

> | Review ID | Product | Sentiment | Reason |
> |---|---|---|---|
> | R001 | Trailmark Hiking Backpack | Negative | Strong chemical smell, took a week to clear |
> | R002 | Breeze Wireless Earbuds | Mixed | Not true noise cancelling, but good for gym |
> | R003 | Breeze Wireless Earbuds | Negative | Earbud failed, support never responded |
> | R004 | Trailmark Hiking Backpack | Negative | Uncomfortable straps, returning it |
> | R005 | Cozy Knit Throw Blanket | Negative | Not warm enough; "fine" is weak praise |
> | R006 | Breeze Wireless Earbuds | Positive | Clear calls, solid battery, great for commute |
> | R007 | Trailmark Hiking Backpack | Mixed | Decent value, but not for serious backpacking |
> | R008 | Lumen Smart Bulbs (4-Pack) | Mixed | Bright colors, but keeps dropping Wi-Fi |
> | R009 | Lumen Smart Bulbs (4-Pack) | Mixed | Great bulbs, terrible app |
> | R010 | Hearth Electric Kettle | Positive | Repeat buyer, still working after a year |
> | R011 | Cozy Knit Throw Blanket | Negative | Arrived stained |
> | R012 | Lumen Smart Bulbs (4-Pack) | Unclear | Compatibility question, no opinion given |
> | R013 | Hearth Electric Kettle | Mixed | Broke at 6 weeks; replacement works |
> | R014 | Hearth Electric Kettle | Mixed | Arrived dented; quick replacement, kettle fine |
> | R015 | Trailmark Hiking Backpack | Negative | Too small, listing misleading |
> | R016 | Trailmark Hiking Backpack | Unclear | Secondhand "fine" gives no real signal |
> | R017 | Trailmark Hiking Backpack | Positive | Extremely durable in rough conditions |
> | R018 | Lumen Smart Bulbs (4-Pack) | Negative | Colors look washed out |
> | R019 | Trailmark Hiking Backpack | Negative | Wrong size sent |
> | R020 | Trailmark Hiking Backpack | Mixed | Color differs from photos, still good bag |
>
> *[Rows R021–R110 omitted]*
>
>
> **Labeled 110 of 110 reviews**
>
> - Positive: 38
> - Negative: 41
> - Mixed: 19
> - Unclear: 12

*Note: all 110 of 110 reviews were labeled. Counts: Positive 38, Negative 41, Mixed 19, Unclear 12.*

---

## Spot-Check Table

Labels were assigned by hand before looking at the model's answers, then compared against Version 5.

| Review ID | Product | My Label | Model's Label (V5) | Agree? |
|---|---|---|---|---|
| R030 | Hearth Electric Kettle | Negative | Negative | Yes |
| R022 | Trailmark Hiking Backpack | Negative | Negative | Yes |
| R068 | Cozy Knit Throw Blanket | Negative | Negative | Yes |
| R078 | Cozy Knit Throw Blanket | Negative | Negative | Yes |
| R024 | Lumen Smart Bulbs (4-Pack) | Negative | Negative | Yes |
| R098 | Lumen Smart Bulbs (4-Pack) | Negative | Negative | Yes |
| R010 | Hearth Electric Kettle | Positive | Positive | Yes |
| R014 | Hearth Electric Kettle | Mixed | Mixed | Yes |
| R016 | Trailmark Hiking Backpack | Unclear | Unclear | Yes |
| R041 | Trailmark Hiking Backpack | Mixed | Mixed | Yes |

**Agreement: 10 of 10**

---

## Analysis

### Techniques used and where

- **Defined categories:** Versions 2–5 (Positive, Negative, Mixed, Unclear)
- **Output format:** Versions 3–5 (table with Review ID, Product, Sentiment, Reason)
- **Few-shot:** Versions 4–5 (four example reviews, including one sarcastic one)
- **Role prompting:** Version 5
- **Constraints:** Version 5 (one label per review, no skipping, reasons under 10 words, sarcasm rule, count at the end)

### How each technique affected the output

I think about this one like a funnel. If you make the funnel hole too big, you get something way too general. Version 1 just asked if the reviews were positive or negative, and it gave back a summary I couldn't sort or count. Once I narrowed it by defining the categories in Version 2, it labeled every single review, and adding the table format in Version 3 gave me a precise look at the data. After that, narrowing it more didn't do much. The examples and rules in Versions 4 and 5 only changed a few labels. The funnel isn't a perfect metaphor, but it's one way to think about it.

### How the model handled tricky reviews

Sarcasm was never the problem. Every sarcastic review (R022, R030, R098 and the rest) was labeled Negative in every version, even Version 1. The reviews that moved around were shipping complaints like R062 and R093, which went from Negative to Unclear and back to Negative, and lukewarm ones like R042 and R092, which went from Unclear to Positive in Version 5.

This is where the funnel is about the shape of the hole and not just the size. Narrowing the prompt didn't fix those reviews, because my categories never said whether a shipping complaint counts against the product. Reshaping the funnel with a rule like "shipping-only complaints count as Unclear" would fix it.

### Did the model label every review?

Yes. Versions 2 through 5 all labeled 110 of 110, and the count line in Version 5 made that easy to confirm. I ran each version as a separate Claude Code subagent instead of in a chat app, which may be why nothing got cut off.

### Spot-check

My labels matched Version 5 on all 10 reviews. Six of my picks were sarcastic though, and the model never got sarcasm wrong, so the sample makes it look a little better than it is. R014 would have been a disagreement if I'd compared against Versions 2 through 4, which called it Positive.

### Biggest difference

Defining the categories. That one change turned a summary into usable data, and everything after it only adjusted a few labels.
