# Customer Review Sorter

## Objective

Practice using few-shot prompting, clear category definitions, and output-format constraints to turn a vague classification request into one that produces consistent, usable results. Along the way, learn to check an LLM's work rather than trusting it at face value.

## Instructions

This activity should take about 20–30 minutes. You will need access to an LLM chat app that accepts file uploads (such as Claude or ChatGPT), and the provided file **`product-reviews.csv`**, which contains 100+ customer reviews for several products.

### Part 1: Start simple

1. Open a new chat, upload `product-reviews.csv`, and send this prompt exactly as written:

   ```text
   Are these reviews positive or negative?
   ```

2. Copy the response somewhere you can refer back to it.
3. Read the output critically. Did the model label each review, or just summarize them? Could you sort or count the results? How did it handle reviews that aren't clearly positive or negative?

### Part 2: Improve the prompt

Rewrite the prompt by applying the techniques below, **one or two at a time**. After each change, run the new prompt (with the file uploaded) and compare the result with the previous version. There is no single "correct" prompt; the goal is to see what each technique contributes.

Techniques to try:

- **Define the categories** – Decide which labels the model should use and what each one means. Are two labels (positive/negative) enough, or do some reviews need another category?
- **Few-shot prompting** – Give the model a few example reviews along with the label you would assign to each. Examples are most helpful for tricky cases, like sarcasm or reviews that praise one thing and complain about another.
- **Output format** – Specify exactly how the results should be structured (for example, a table with specific columns) so you could paste them into a spreadsheet.
- **Constraints** – Add rules, such as how long any explanation can be, what to do if a review is unclear, or that every review must receive exactly one label.
- **Role prompting** – Tell the model who it is (for example, someone who analyzes customer feedback for a company) before giving it the task.

> **Tip:** Run each new version in a **fresh chat** and re-upload the file. Otherwise, the model may be influenced by earlier messages, and it becomes harder to tell which change made the difference.

> **Watch out:** With 100+ reviews, the model may stop partway through, skip reviews, or quietly summarize the rest. Check that every review was labeled. If it wasn't, adjust your prompt or ask the model to continue.

### Part 3: Check the model's work

1. Pick **10 reviews** from the file, including at least a few that seem tricky.
2. Label those 10 yourself **before** looking at the model's answers.
3. Compare your labels with the model's labels from your best prompt. Where you disagree, decide who is right, and whether a change to your prompt (a clearer category definition, another example) fixes it.

## Example Interaction

The example below uses a few reviews pasted directly into the chat (not from the provided file), so you can see the pattern without getting an answer to copy.

**Simple prompt:**

```text
Are these reviews positive or negative?

1. Love this blender. Smoothies every morning, zero complaints.
2. Oh great, it stopped working the day after the warranty ended. Fantastic.
3. Blends well but it's louder than a jet engine.
```

**Typical output (a summary, not usable data):**

```text
Overall, the reviews are mixed. The first review is positive, while the
second expresses frustration about durability. The third review mentions
both strengths and weaknesses of the blender.
```

**Improved prompt (role + defined categories + few-shot + output format + constraints):**

```text
You analyze customer feedback for a kitchen appliance company.

Label each review below with exactly one sentiment:
- Positive: the customer is happy overall
- Negative: the customer is unhappy overall
- Mixed: the review contains clear praise AND a clear complaint

Examples:
"Works perfectly, would buy again." -> Positive
"Sure, I LOVE cleaning up leaks every day." -> Negative (sarcasm)
"Great taste, but the lid cracked in a week." -> Mixed

Return a table with these columns: Review #, Sentiment, Reason.
Keep each reason under 10 words.

1. Love this blender. Smoothies every morning, zero complaints.
2. Oh great, it stopped working the day after the warranty ended. Fantastic.
3. Blends well but it's louder than a jet engine.
```

**Improved output:**

```text
| Review # | Sentiment | Reason                                  |
|----------|-----------|-----------------------------------------|
| 1        | Positive  | Daily use, no complaints                |
| 2        | Negative  | Sarcastic complaint about breaking      |
| 3        | Mixed     | Blends well, but very loud              |
```

Notice how the improved version labels every review the same way, handles the sarcastic review correctly, and produces results you could sort or count.

## Deliverable

Submit a write-up (a document or slide deck works well) that includes the following:

1. **Prompt log** – Every prompt you ran, in order, each followed by the model's output. Label each one with a version number (e.g., "Version 3"). For long outputs, you may include the first 15–20 rows plus a note on whether all reviews were labeled.

2. **Spot-check table** – Your 10 hand-labeled reviews, showing the review ID, your label, the model's label, and whether you agreed.

3. **Analysis** – A brief reflection (a few short paragraphs or bullet points) covering:
   - Which techniques you used, and where in your prompts you used them
   - How each technique affected the output. Did it improve, stay the same, or get worse? Point to specific differences between versions.
   - How the model handled tricky reviews (sarcasm, mixed opinions, unclear reviews), and what you changed in response
   - Whether the model labeled every review, and what you did if it didn't
   - Which technique made the biggest difference for you, and why you think that was
