# Prompt Logs
- [Water Bottle Prompts](gemini/logs-0.txt)
- [Noise-Canceling Headphones Prompts](gemini/logs-1.txt)
- [Smart Thermostat Prompts](gemini/logs-2.txt)

# Overview of Methods
For each product, all prompt components remained identical except for the product name itself. Each prompt was programmatically assembled from seven distinct string segments. The `basePrompt` defines the basic zero-shot prompt that subsequent iterations build upon, with each new version layering in additional prompting techniques.

The techniques implemented include:
- Role prompting
- Context
- Constraints
- Few-shot prompting
- Output format

The order of each technique within the prompt is based on its natural placement in the overall text. Finally, although the log files display the outputs sequentially as if they occurred in a single thread, each prompt was executed in a completely fresh conversation instance.

# Analysis
A common result from the base prompt was receiving a response with multiple descriptions tailored to different applications. Without any context, the model defaulted to generating options for several possible audiences and use cases, choosing its own formatting and heavily relying on Markdown.

Adding a role and output format improved the generations significantly; the responses became much more focused and stopped offering multiple options. However, without specific product context, the variance in the generated features was very high. The descriptions often included elaborate, hallucinated details that were not necessarily true of the product.

Adding context made the generations much more grounded. The outputs began incorporating consistent product features and details, properly appealing to the target audience, and describing the specific item rather than a generic archetype. Instead of reading like a generic landing page header, the next iteration focused directly on the product and its buyer: *"Step into an uncompromising realm of sound with the Apex One Wireless Headphones..."* turned into *"Engineered for the uncompromising audiophile and the dedicated connoisseur..."*

The final addition of the few-shot example and style constraints helped fine-tune the result, making the result more specific and direct about who the product is for while producing consistently longer, more detailed paragraphs. Adding an example of how NVIDIA advertises its 50-series graphics cards made the opening much more focused on the engineering and foundation of the product: *"Elevate the atmosphere of your space with the Aetheris Smart Thermostat..."* changed to *"Forged from aerospace-grade Grade 5 titanium and crowned with diamond-cut sapphire crystal..."*

Overall, **context** made the biggest difference because it anchored the model to real product attributes and a clear audience, whereas the other techniques primarily shaped the structure and tone. With even more granular prompts for each technique, such as providing an exhaustive spec sheet so the model does not have to invent features, it would easily be possible to achieve higher-quality results.