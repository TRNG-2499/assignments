package com.letmegetabyte;

import com.letmegetabyte.wrapper.Conversation;

public class Main {
    public static String[] setProduct(String product, String[] prompts) {
        String[] out = new String[prompts.length];
        for (int i = 0; i < prompts.length; i++) {
            out[i] = String.format(prompts[i], product);
        }

        return out;
    }
    public static void main(String[] args) {
        String basePrompt = "Write a product description for %s.";
        String role = "You are an advertising agent for a tech company specializing in modern, premium electronics and gadgets.";
        String context1 = "The product is made with premium materials like titanium.";
        String context2 = "The target audience is enthusiasts and collectors.";
        String context3 = "The description will go on a marketing site";
        String constraint = "The description should be professional, detailed, and elaborate.";
        String example =
        "Here's an example:\n" +
        "Powered by NVIDIA Blackwell, GeForce RTX™ 50 Series GPUs bring game-changing capabilities to gamers and creators. " +
        "Equipped with a massive level of AI horsepower, the RTX 50 Series enables new experiences and next-level graphics " +
        "fidelity. Enhance graphics and multiply performance with NVIDIA DLSS, generate images at unprecedented speed, and " +
        "unleash your creativity with NVIDIA Studio.";
        String format = "The description should be a single, cohesive paragraph.";

        try {
            // build context
            String ctx = String.format("%s %s %s", context1, context2, context3);
            // build base + role + format
            String promptBRF = String.format("%s\n%s\n%s", role, basePrompt, format);
            // build base + role + format + ctx
            String promptBRFC = String.format("%s\n%s\n%s\n%s", role, basePrompt, ctx, format);
            // build base + role + format + ctx + example + constraint
            String promptBRFCEC = String.format("%s\n%s\n%s\n%s\n%s\n%s", role, basePrompt, ctx, format, constraint, example);

            String[] promptsBase = {basePrompt, promptBRF, promptBRFC, promptBRFCEC};
            String[] promptsWB = setProduct("a water bottle", promptsBase);
            String[] promptsNCH = setProduct("noise-canceling headphones", promptsBase);
            String[] promptsST = setProduct("a smart thermostat", promptsBase);
            String[][] prodPrompts = {promptsWB, promptsNCH, promptsST};

            for (int i = 0; i < prodPrompts.length; i++) {
                String[] prod = prodPrompts[i];
                for (String prompt : prod) {
                    System.out.println(prompt);
                    System.out.println();
                    Conversation conversation = new Conversation(prompt);
                    conversation.archive(String.format("logs-%d.txt", i));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}