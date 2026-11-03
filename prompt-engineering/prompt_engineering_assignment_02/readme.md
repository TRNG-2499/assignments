# Prompt Logs

- [Ver 0](logs-0.txt)
- [Ver 1](logs-1.txt)
- [Ver 2](logs-2.txt)
- [Ver 3](logs-3.txt)

# Overview of Methods

Each prompt was programmatically generated using seven parts. The `basePrompt` defines the most basic zero-shot form of the prompt, and is what the rest of the prompts build on, with each iteration including more of the prompt parts and therefore more prompting techniques.

The techniques implemented include:
- Role prompting
- Context
- Constraints
- Few-shot prompting
- Output format

The order of each technique in the prompt is based on its natural placement in the context of the whole prompt.

Logs at the bottom of the file show errors from attempting to parse the response. It is a stringified array containing errors indicating either exactly why the response is unparsable or if there are any missing entries. This is checked programmatically by looking at the CSV itself and comparing the review IDs to the IDs present in the response. Additionally, the goal of the techniques was to get the response to be properly formatted for a CSV file, so a successful generation will not have CSV parsing errors.

Finally, although the logs show each conversation as if they occur in a single chat, they do not. Each prompt generates a new conversation.

# Spot-check Table
|ID  |Human Grade |Human Reason                     |AI Grade |AI Reason                     |Consensus|
|----|:----------:|:-------------------------------:|:-------:|:----------------------------:|:-------:|
|R001|NEGATIVE    |smell                            |NEGATIVE |chemical odor                 |AGREE    |
|R002|POSITIVE    |noise isolation, comfort         |POSITIVE |good for gym                  |AGREE    |
|R003|NEGATIVE    |defect, customer service         |NEGATIVE |charging failure              |AGREE    |
|R004|NEGATIVE    |comfort                          |NEGATIVE |comfort                       |AGREE    |
|R005|NEGATIVE    |warmth                           |NEGATIVE |insufficient warmth           |AGREE    |
|R006|POSITIVE    |sound quality, battery           |POSITIVE |call quality and battery      |AGREE    |
|R007|POSITIVE    |value                            |POSITIVE |good value                    |AGREE    |
|R008|POSITIVE    |vibrant                          |NEGATIVE |connectivity issues           |DISAGREE |
|R009|POSITIVE    |function                         |POSITIVE |bulb quality                  |AGREE    |
|R010|POSITIVE    |durability                       |POSITIVE |durability                    |AGREE    |

# Analysis

The basic response was fairly informative for a person; it contained a lot of information and even had a table with decent, consistent formatting. However, it would be very hard to process programmatically. At the very least, it did not seem to miss any reviews.

With a role and format, the response was cleaned up a lot. Everything became orderly, and at this stage the information could definitely be parsed programmatically. However, it left something to be desired as the descriptions were still too variable. It would be a bit hard to use those descriptions to search for specific criteria later on.

I would say context was not very necessary and seemed to make little difference, if any at all.

The biggest addition would certainly be the example and constraint. At this stage, the generations were actually fully parsable as CSV files, and the log stopped showing errors. No reviews were missed, and the descriptions were made more concise.