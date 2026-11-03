
## 1. Prompt Log

### Version 1: Zero-shot (baseline)

> Are these reviews positive or negative?

**Output:** All 110 reviews were labeled. The model added two categories I hadn't asked for, Mixed and Neutral.

| Product | Pos | Neg | Mixed | Neutral |
|---|---|---|---|---|
| Backpack | 7 | 8 | 4 | 3 |
| Earbuds | 7 | 7 | 4 | 4 |
| Blanket | 8 | 5 | 5 | 4 |
| Smart Bulbs | 7 | 9 | 3 | 3 |
| Kettle | 7 | 8 | 4 | 3 |
| **Total** | **36** | **37** | **20** | **17** |

- The model flagged 10 sarcastic reviews and labeled them Negative, e.g. R022 ("Ten stars") and R108 ("Truly impressive engineering").
- It labeled questions, shipping-only comments and flat remarks as Neutral.

### Version 2: Few-shot

> Classify each product review as Positive or Negative.
> Review: "Fits perfectly and the fabric feels premium. Already ordered a second one." Sentiment: Positive
> Review: "Broke after three uses. Total waste of money." Sentiment: Negative

**Output:** All 110 reviews were labeled, 55 Positive and 55 Negative. The model said about 48 reviews didn't fit two classes cleanly:

- Sarcasm (10): labeled Negative.
- Mixed (19): labeled by whichever side was stronger.
- Lukewarm (9): close to coin flips.
- No product opinion (9): labeled arbitrarily.

| ID | Review (short) | Label |
|---|---|---|
| R001 | Smells like chemicals out of the box | Negative |
| R002 | Not true noise cancelling, still good for gym | Positive |
| R003 | Left earbud stopped charging | Negative |
| R004 | Straps dig into shoulders | Negative |
| R005 | Not warm enough, fine as decorative | Negative |
| R006 | Perfect for commute | Positive |
| R007 | Decent for the money, not for serious backpacking | Positive |
| R008 | Bright, but disconnects from Wi-Fi | Negative |
| R009 | Great bulbs, terrible app | Positive |
| R010 | Second one bought, still going strong | Positive |

### Version 3: Defined categories and constraints

> Classify only the earbuds products and review them as Positive or Negative. Give it only one label and keep it concise.

**Output:** All 22 earbud reviews were labeled, 10 Positive and 12 Negative.

- **Positive:** R002, R006, R033, R052, R054, R056, R072, R077, R094\*, R101\*
- **Negative:** R003, R028, R029, R038, R060, R062, R066, R076, R097, R103, R108, R109

\*R094 and R101 express no opinion. The model labeled them Positive only because they don't complain.

### Version 4: Role prompting and output format

> You are a sentiment analyst to analyze how these products are doing and what can be improved for these products. List your answer in CSV format with id, product, review (positive, negative, or neutral), and major praise/complaints summarized.

**Output:** All 110 reviews were labeled, as 43 Positive, 44 Negative and 23 Neutral.

| Product | Pos | Neg | Neu | Main issue |
|---|---|---|---|---|
| Backpack | 10 | 8 | 4 | Zipper, buckle and stitching failures |
| Earbuds | 8 | 8 | 6 | Hardware defects, poor mic |
| Blanket | 9 | 9 | 4 | Shedding, shrinking, unraveling |
| Kettle | 8 | 9 | 5 | Safety: leaking base, hot handle |
| Smart Bulbs | 8 | 10 | 4 | App and Wi-Fi instability |

These are the first 15 rows. The full CSV has all 110 reviews labeled.

| id | product | review | major_praise_complaints |
|---|---|---|---|
| R001 | Backpack | Negative | Chemical smell |
| R002 | Earbuds | Positive | Good for gym; noise cancelling overstated |
| R003 | Earbuds | Negative | Earbud stopped charging; no support reply |
| R004 | Backpack | Negative | Straps dig into shoulders |
| R005 | Blanket | Negative | Not warm enough for winter |
| R006 | Earbuds | Positive | Clear calls, solid battery |
| R007 | Backpack | Neutral | Decent value; not for serious hikes |
| R008 | Smart Bulbs | Negative | Drops Wi-Fi |
| R009 | Smart Bulbs | Neutral | Great bulbs; terrible app |
| R010 | Kettle | Positive | Durable after a year |
| R011 | Blanket | Negative | Arrived stained |
| R012 | Smart Bulbs | Neutral | Question about Google Home |
| R013 | Kettle | Neutral | Failed at 6 weeks; replacement works |
| R014 | Kettle | Positive | Arrived dented; fast replacement |
| R015 | Backpack | Negative | Smaller than listed |

## 2. Spot-Check Table

I compared my labels with the Version 4 labels and agreed on 8 of 10.

| ID | My label | Model (V4) | Agree? |
|---|---|---|---|
| R005 | Negative (leans Neutral) | Negative | Yes |
| R007 | Positive | Neutral | No |
| R009 | Positive | Neutral | No |
| R012 | Neutral | Neutral | Yes |
| R013 | Neutral | Neutral | Yes |
| R014 | Positive | Positive | Yes |
| R017 | Positive | Positive | Yes |
| R022 | Negative | Negative | Yes |
| R024 | Negative | Negative | Yes |
| R056 | Positive | Positive | Yes |

- **R007:** "Decent" and "not for serious backpacking" make it closer to Neutral. I think the model is right.
- **R009:** The praise is for the bulbs, but the bulbs need the app to work, so Neutral is reasonable.

## 3. Analysis

**Techniques and where I used them**
- **V2, few-shot:** two labeled examples before the task.
- **V3, constraints:** "only the earbuds," "only one label," "keep it concise."
- **V4, role and output format:** "You are a sentiment analyst" plus the CSV columns. This version also added a Neutral category.

**Effect of each technique**
- **Few-shot: mixed.** It kept the model to two labels (55/55). Both of my examples were easy, though, so they didn't help with the hard cases.
- **Constraints: same accuracy, cleaner output.** The output was concise, but the two-label limit still forced arbitrary labels, such as R094 and R101 labeled Positive.
- **Role and format: improved.** With Neutral allowed, six forced earbud labels (R029, R038, R060, R094, R097, R101) became Neutral. The summary column also made the output actionable, for example by flagging the kettle safety issues.

**Tricky reviews**
- **Sarcasm:** caught correctly in every version (R022, R066, R108).
- **Mixed opinions:** labeled by the stronger side until V4, where even splits like R097 moved to Neutral.
- **Unclear reviews and questions:** labeled arbitrarily until Neutral was added. One gap remains: shipping-only reviews (R062, R093) are still Negative. The next prompt should say to label those Neutral.

**Completeness:** Every version labeled every review it was given. I checked that each version's totals added up to 110, or to 22 for V3.

**Biggest difference:** Adding the Neutral category in V4 made the biggest difference. The other techniques changed the format, but the model kept guessing on about a fifth of the reviews until the categories fit the data.
