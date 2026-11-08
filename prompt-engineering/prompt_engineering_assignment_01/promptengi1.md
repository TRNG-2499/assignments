# The Product Description Makeover

**Name:** Ethan Surati

---

## Part 1 and 2: Prompt Log – Water Bottle

### Water Bottle – Version 1

**Techniques used:** None (baseline)

**Prompt:**

```text
Write a product description for a water bottle.
```

**Output:**

> **HydroPeak Insulated Water Bottle (24 oz)**
>
> Cold stays cold and hot stays hot, wherever the day takes you. The HydroPeak's double-wall vacuum insulation keeps drinks icy for up to 24 hours and hot for up to 12, so your morning coffee is still warm at lunch and your afternoon water is still cold at the gym.
>
> It's made from 18/8 food-grade stainless steel, so it won't hold onto old flavors or leach anything into your drink. It's BPA-free from cap to base. The leak-proof lid seals tight enough to toss in a backpack, and the wide mouth fits ice cubes and makes cleaning easy.
> The powder-coated finish resists sweating and scratches and gives you a solid, no-slip grip.
>
> At 24 ounces, it holds enough to get you through a workout or a commute without being too bulky for most cup holders.
>
> **Features:**
> - Double-wall vacuum insulation (24 hrs cold / 12 hrs hot)
> - 18/8 stainless steel, BPA-free
> - Leak-proof, one-hand lid with carry loop
> - Wide mouth for ice and easy cleaning
> - Sweat-free, scratch-resistant powder coat
> - Fits most standard cup holders
>
> *Hydration that keeps up with you.*
>
> ---
>
> If you send me the real product details, like the brand name, size, materials, price point and who it's for, I can tailor this. I can also make it shorter for a listing like Amazon or Shopify, or write it in a different tone.

---

### Water Bottle – Version 2

**Techniques used:** Role prompting, context (audience)

**Prompt:**

```text
You are designing a water bottle for people that hike in the mountains. How would you write a product description for this water bottle?
```

**Output:**

> I'd lead with the problems mountain hikers actually have (weight, cold, rough handling, refilling from streams), back each claim with a specific detail, and keep it short enough to skim on a phone. Here's how it might read:
>
> **Summit 750 Insulated Trail Bottle**
>
> Built for the long climb and the cold summit. The Summit 750 holds 25 oz of water in a double-wall stainless steel body that weighs just 11 oz. It keeps drinks cold for 24 hours in summer heat and stops water from freezing on below-zero ridgelines.
>
> - **Gloves-on cap:** An oversized loop and wide grip ridges let you open it without taking off your mittens.
> - **Wide mouth:** Fill it fast from a stream, add ice, or fit a standard filter.
> - **Trail-tough finish:** A powder coat that won't chip and a silicone base bumper that survive drops on granite.
> - **Clip anywhere:** A carabiner loop holds it on your pack strap or harness.
> - **Leakproof:** Toss it in your pack upside down and nothing gets out.
> - **Clean materials:** BPA-free and doesn't keep the taste of whatever you had in it last.
>
> *Carry less. Climb farther.*
>
> A few choices behind it:
>
> - **Specific numbers over hype.** "Keeps water from freezing at 10°F" is more convincing than "extreme performance."
> - **Features tied to moments.** Every bullet connects to something that happens on a trail, like cold hands, stream refills, or a dropped pack.
> - **Weight up front.** Hikers count ounces, so it goes in the first lines.
> - **Short tagline.** It's useful for packaging and ads.
>
> I can also write a shorter version for a store listing or Instagram caption, or one aimed at a more specific group, like ultralight backpackers or winter mountaineers.

---

### Water Bottle – Version 3

**Techniques used:** Context (product features, brand, audience)

**Prompt:**

```text
Design a product description for a water bottle that is made out of a highly durable aluminum alloy that keeps the liquid inside cold for at least 12 hours. This is for a company called Hydropack. Make it similar to other water bottle products on the market. This product is designed for people that like to go climbing. Its durable surface should resist bumps and dings better than most water bottles. And due to its aluminum construction, it is very light when compared to other bottles.
```

**Output:**

> Here's a product description in the format most outdoor bottle brands use: a headline, a short intro, feature bullets, then specs.
>
> ---
>
> #### Hydropack Summit Aluminum Bottle
>
> **Built for the crag. Light enough to forget it's there.**
>
> When you're halfway up a route or hiking out to the wall, every ounce counts and your gear takes a beating. The Hydropack Summit is made from a high-strength aluminum alloy that takes the knocks, scrapes and drops of climbing days. It also keeps your water cold for 12+ hours, so your last sip at the top is as cold as your first at the trailhead.
>
> **Why climbers choose the Summit**
>
> * **Cold for 12+ hours.** Double-wall insulation keeps water cold from your morning approach through your last send of the day.
> * **Built to take a beating.** The tough alloy shell resists dents and dings better than standard bottles, whether it's banging against rock, rolling off a boulder or riding in a packed crag bag.
> * **Featherlight aluminum.** It weighs noticeably less than comparable stainless steel bottles, which means less weight on your harness, in your pack and on long approaches.
> * **Clip-ready design.** An integrated carry loop clips onto a carabiner, harness gear loop or pack strap.
> * **Leakproof lid.** A secure seal means you can toss it in your bag next to your shoes and chalk without worrying about spills.
> * **Grippy finish.** A textured powder coat stays easy to hold with chalky or sweaty hands.
> * **Clean taste.** BPA-free, with a lined interior that won't hold onto flavors.
>
> **Specs**
>
> * Capacity: [__ oz / __ mL]
> * Weight: [__ oz / __ g]
> * Material: High-strength aluminum alloy, double-wall insulated
> * Cold retention: 12+ hours
> * Care: Hand wash recommended
> * Colors: [list colorways]
>
> **Hydropack Summit: tough enough for the wall, light enough for the climb.**
>
> ---
>
> A few things to check before you publish:
>
> * **Specs:** I left capacity, weight and colors blank so the listing doesn't make up numbers.
> * **Insulation:** Plain aluminum alone won't keep water cold for 12 hours, so I wrote it as double-wall insulated. Make sure that matches the actual product.
> * **Features you didn't mention:** You said nothing about the carry loop, leakproof lid, textured grip or BPA-free lining. Cut any that don't apply.

---

### Water Bottle – Version 4 (over-constrained)

**Techniques used:** Role prompting, context, constraints (deliberately too many, and some that conflict)

**Prompt:**

```text
You are a copywriter for Hydropack, an outdoor gear brand.

Write a product description for our water bottle. Features:
- Made from a highly durable aluminum alloy
- Keeps liquid cold for at least 12 hours
- Resists bumps and dings better than most bottles
- Very light compared to other bottles

Audience: rock climbers.

Rules:
- Exactly 40 words.
- Write it as a single sentence.
- Include a headline and three bullet points.
- Mention all of these: the Hydropack name, aluminum alloy, 12 hours cold, climbers, dent resistance, light weight, a carabiner loop, a lifetime warranty, BPA-free, dishwasher safe, and that it comes in 3 colors.
- Tone must be casual and fun, but also professional with no slang.
- Do not use the words "bottle," "water," "cold," "light," or "durable."
- Do not use any adjectives.
```

**Output:**

> A few of these rules can't all be true at once, so here's a version that keeps as many as possible, followed by the ones I had to bend.
>
> **Hydropack: Hydration Made for Climbers**
>
> - Aluminum alloy shrugs off dents and weighs next to nothing on your harness.
> - Keeps drinks chilled 12 hours, from approach to summit.
> - Includes a carabiner loop, lifetime warranty, BPA-free build, dishwasher-safe design, and 3 colors.
>
> That's exactly 40 words, counting the headline and treating "BPA-free" and "dishwasher-safe" as one word each. It hits all 11 required points and doesn't use "bottle," "water," "cold," "light," or "durable."
>
> **Where the rules conflict:**
>
> 1. **Single sentence vs. headline + three bullets.** A headline and three bullets are separate units by definition, so it can't also be one sentence. I went with the headline and bullets. If you'd rather have one sentence, I can drop that structure.
> 2. **No adjectives vs. the required features.** "BPA-free" and "dishwasher safe" are adjectives, so mentioning them means using adjectives. I kept everything else adjective-free and worded around "light" and "cold" ("weighs next to nothing," "chilled").
> 3. **No adjectives vs. "casual and fun."** Most playful copy depends on descriptive words. Without them, the fun has to come from verbs and imagery ("shrugs off dents," "from approach to summit"), so the tone ends up more crisp than bubbly.
>
> Tell me which rules matter most, like the single sentence or the no-adjectives rule, and I can write a version that follows those strictly and relaxes the others.

---

## Part 3: Prompt Log – New Products

### Standing Desk – Version 1

**Techniques used:** Context (audience, where it appears), constraints (size, easy assembly), output format (bulleted list)

**Prompt:**

```text
Design a standing desk for programmers. The desk cannot be too large and needs to be easy to assemble. The product description will appear on a Amazon web page. This should be a bulleted list describing the desk's features for this specific group of people and why it would be beneficial for them to buy.
```

**Output:**

> **DevStand Compact Electric Standing Desk, 40" x 24", Tool-Free Assembly**
>
> * **SMALL FOOTPRINT, PLENTY OF ROOM:** The 40" x 24" top fits in a bedroom, apartment corner, or small office. It still has room for a laptop plus two 24" monitors, or one ultrawide, without pushing your keyboard to the edge.
> * **SETS UP IN UNDER 15 MINUTES:** The frame and motor come pre-assembled. Snap the legs into place, set the desktop on the frame, and tighten 4 hand knobs. You don't need any tools or a second person.
> * **STEADY AT TYPING HEIGHT:** A reinforced crossbar and steel feet keep the desk from wobbling when you're typing at standing height, so your monitors don't shake every time you hit Enter.
> * **4 MEMORY PRESETS:** Save your sitting height, your standing height, and two more. One tap moves the desk from 28" to 47.5" at 1.4" per second, so switching positions doesn't break your focus mid-task.
> * **BUILT-IN POWER AND CHARGING:** The front-edge hub has 2 AC outlets, a 65W USB-C PD port, and a USB-A port. You can charge your laptop, phone, and headphones without crawling under the desk.
> * **CABLE MANAGEMENT INCLUDED:** An under-desk tray, a rear grommet, and a cable spine that moves with the desk keep monitor, dock, and power cables tidy and keep them from getting yanked when the desk changes height.
> * **READY FOR MONITOR ARMS:** The solid 1" edge works with clamp-style arms, so you can lift your screens to eye level and free up surface space.
> * **QUIET ENOUGH FOR STANDUPS:** The motor runs under 45 dB, so you can change heights during a video call or pair programming session without anyone hearing it.
> * **REMINDERS TO GET UP:** An optional sit-stand reminder on the control panel prompts you to change position. That helps with the back and wrist strain that comes with long debugging sessions.
> * **BUILT FOR DAILY USE:** It holds up to 176 lbs, stops and reverses if it hits something on the way down, and has a scratch-resistant matte surface that works with a mouse without a pad. It's backed by a 5-year frame and motor warranty.
>
> If you tell me the price point or who you're mainly selling to, like remote workers or students, I can adjust the specs and wording to fit.

---

### Noise-Canceling Headphones – Version 1

**Techniques used:** Context (product features), constraints (topics that must be covered)

**Prompt:**

```text
Write a product description for noise-canceling headphones. These headphones are wireless and contain a battery that can be recharged. Write about its long battery life and surround sound features. Similar to other studio headphones, describe how its quality is close and can match studio level headphones
```

**Output:**

> **Studio Sound, Unplugged**
>
> Hear your music the way it was meant to sound. These wireless noise-canceling headphones bring studio-level audio out of the booth and into your everyday life, with no cables to hold you back.
>
> **Silence the world.** Advanced active noise cancellation blocks out traffic, chatter, and engine hum, so nothing comes between you and your sound. Whether you're on a crowded commute or focusing at your desk, you set the volume of the world around you.
>
> **Sound that surrounds you.** Immersive surround sound puts you in the center of every track, film, and game. Vocals come through clear and present, bass hits deep without muddying the mix, and the highs stay crisp at any volume. Every layer sits right where the artist placed it.
>
> **Quality that rivals the studio.** Precision-tuned drivers deliver the balanced, detailed response you'd expect from professional studio headphones. You'll catch the subtle details most headphones miss, from the breath before a lyric to the decay of a cymbal. For producers, creators, and anyone who takes their listening seriously, it's sound you can trust.
>
> **Battery that keeps up.** A long-lasting rechargeable battery gets you through days of listening on a single charge. When you do need to power up, a quick charge gets you back to your playlist in minutes.
>
> **Built for all-day wear.** Soft, cushioned ear cups and an adjustable headband keep you comfortable through long sessions, so you can listen as long as the battery lasts.
>
> Wireless freedom. Studio-grade sound. Total immersion.
>
> ---
>
> I left out specific numbers like battery hours, charge time, and Bluetooth range. If you have the real specs, send them over and I'll add them, since hard numbers usually help sell the product.

---

## Analysis

### Techniques used and where

- **Role prompting:** Water Bottle Version 2 and Version 4
- **Context:** Water Bottle Versions 2–4, Standing Desk, Headphones
- **Constraints:** Water Bottle Version 4, Standing Desk (size, easy assembly), Headphones (topics to cover)
- **Output format:** Standing Desk (bulleted list for an Amazon page)
- **Few-shot:** not tested (see below)

### How each technique affected the output

Adding constraints and context to a prompt is a lot like sharpening a stick. Each one shapes the output closer to what you're actually looking for, and if you sharpen it enough you end up with something really useful. But you can over-sharpen it. Once there are too many constraints the quality starts to drop, so there's a butter zone where you want your prompt to sit.

You can see this with the water bottle. Version 1 had nothing to go on, so it made up a brand name, specs and a generic audience. Once I gave it real details in Version 3 (Hydropack, aluminum, 12 hours cold, climbers), it used those and left blanks instead of guessing. In the over-constrained Version 4, I gave it rules that fought each other. It hit the exact word count and every required feature, but the copy came out flat, and the last bullet was basically a list of features crammed together.

### Times the model ignored the prompt or made up details

Whenever I didn't give it specs, it made them up. Version 1 invented the HydroPeak name and 24-hour insulation, Version 2 invented an 11 oz weight, and the standing desk invented exact numbers like 65W USB-C, under 45 dB and a 176 lb capacity. Giving it real details in Version 3 fixed most of that.

In Version 4 it couldn't follow every rule, but it pointed out which rules couldn't work together instead of just breaking, so the stick got blunt instead of snapping. From my experience with other models, I'd expect a smaller or locally run model to snap instead and drop rules without saying anything.

### Few-shot

I didn't test few-shot. My guess is that copying an existing example would make the output feel like somebody else wrote it, since it's trying to match something that already exists.

### Biggest difference

Context made the biggest difference, because it's what stopped the model from making up details.

This also raises a question outside the scope of this assignment: could you use an AI to find that butter zone for you, and would that prompt be reliable?
