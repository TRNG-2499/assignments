# The Product Description Makeover

## Objective

Practice turning a vague, one-line prompt into a strong one by layering in prompt engineering techniques such as role prompting, added context, constraints, and few-shot examples. Along the way, observe how each change affects the quality and consistency of the model's output.

## Instructions

This activity should take about 20–30 minutes. You will need access to an LLM chat app (such as Claude or ChatGPT).

### Part 1: Start simple

1. Open a new chat and send this prompt exactly as written:

   ```text
   Write a product description for a water bottle.
   ```

2. Copy the response somewhere you can refer back to it (a notes app or document works well).
3. Read the output critically. What feels generic? What information is missing? Who does it seem to be written for?

### Part 2: Improve the prompt

Rewrite the water bottle prompt by applying the techniques below, **one or two at a time**. After each change, run the new prompt and compare the result with the previous version. There is no single "correct" prompt; the goal is to see what each technique contributes.

Techniques to try:

- **Role prompting** – Tell the model who it is (for example, a type of writer or expert) before giving it the task.
- **Context** – Describe the product's features, who the customer is, and where the description will appear (a website, a social media post, an online marketplace listing).
- **Constraints** – Set limits or rules for the output, such as length, tone, reading level, words or phrases to avoid, or elements that must be included.
- **Few-shot prompting** – Include one or more example descriptions written in the style you want, so the model can follow the pattern. You can write these yourself or find a style you like.
- **Output format** – Specify the structure of the response, such as a headline followed by bullet points.

> **Tip:** Run each new version in a **fresh chat**. Otherwise, the model may be influenced by earlier messages, and it becomes harder to tell which change made the difference.

### Part 3: Apply your techniques to new products

Choose **at least two** products from the list below. For each one, write an improved prompt from scratch that uses **at least three** of the techniques from Part 2.

- Noise-canceling headphones
- Standing desk
- Reusable grocery bag
- Smart thermostat
- Kids' school backpack
- Monthly coffee subscription
- Ergonomic office chair
- Indoor houseplant (such as a snake plant)
- Trail running shoes
- Budget phone case

Try to pick products that are different from one another (for example, one tech product and one everyday item) so you can see how your prompt needs to adapt.

## Example Interaction

The example below uses a product that is **not** on the list, so you can see the pattern without getting an answer to copy.

**Simple prompt:**

```text
Write a product description for a desk lamp.
```

**Typical output (generic, could describe almost any lamp):**

```text
Brighten up your workspace with our sleek and stylish desk lamp! Designed
with both form and function in mind, this lamp provides the perfect amount
of light for reading, working, or relaxing. Its modern design complements
any décor, making it a must-have addition to your home or office.
```

**Improved prompt (role + context + constraints + few-shot):**

```text
You are a copywriter for an online store that sells minimalist home office
products.

Write a product description for our LED desk lamp. Key features:
- 5 brightness levels
- USB-C charging port in the base
- Matte black aluminum finish

Audience: remote workers setting up a small home office.

Rules:
- 60–80 words
- Calm, practical tone with no exclamation points
- End with one sentence about who the lamp is best for

Here is an example of our house style:
"The Linen Notebook keeps things simple: 120 dot-grid pages, a lay-flat
binding, and a cover that softens with use. It fits in most laptop sleeves
and doesn't fight for attention on your desk. Best for people who think
better on paper."
```

**Improved output:**

```text
The Halo Desk Lamp gives you exactly the light you need and nothing more.
Choose from five brightness levels for early calls or late-night focus,
and charge your phone from the USB-C port built into the base. The matte
black aluminum finish stays clean and understated on any desk. Best for
remote workers who want a tidy setup that works as hard as they do.
```

Notice how the improved version is specific, matches a clear style, and follows every rule in the prompt.

## Deliverable

Submit a write-up (a document or slide deck works well) that includes the following:

1. **Prompt log** – Every prompt you ran, in order, each followed by the model's full output. Label each one with the product and a version number (e.g., "Water Bottle – Version 3"). Include:
   - The original water bottle prompt and its output
   - Each improved version of the water bottle prompt and its output
   - Your improved prompts and outputs for at least two products from the list

2. **Analysis** – A brief reflection (a few short paragraphs or bullet points) covering:
   - Which techniques you used, and where in your prompts you used them
   - How each technique affected the output. Did it improve, stay the same, or get worse? Point to specific differences between versions.
   - Any times the model ignored part of your prompt or made up details you didn't provide, and what you changed in response
   - Which technique made the biggest difference for you, and why you think that was
