package com.letmegetabyte.wrapper;

import com.google.genai.Client;
import com.google.genai.gaos.models.interactions.CreateModelInteraction;
import com.google.genai.gaos.models.interactions.Interaction;
import com.google.genai.gaos.models.interactions.InteractionsInput;
import com.google.genai.gaos.models.interactions.Model;
import com.google.genai.gaos.models.operations.CreateInteractionRequestBody;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Manages stateful, multi-turn conversations with Gemini.
 * <p>
 * Initialized with an initial prompt and optionally a model. 
 */
public class Conversation {
    private Client client = new Client();;
    private String model = "gemini-3.8-flash";
    private String prompt;
    private Interaction prevInteraction;

    public Conversation(String initPrompt) {
        this.prompt = initPrompt;
        this.prevInteraction = interact(initPrompt);
    }
    
    public Conversation(String model, String initPrompt) {
        this.model = model;
        this.prompt = initPrompt;
        this.prevInteraction = interact(initPrompt);
    }

    public Interaction interact() {
        CreateModelInteraction params =
            CreateModelInteraction.builder()
                .model(Model.of(this.model))
                .input(InteractionsInput.of(this.prompt))
                .previousInteractionId(this.prevInteraction != null ? this.prevInteraction.id().orElse("") : "")
                .build();

        Interaction interaction =
            client.interactions.create(CreateInteractionRequestBody.of(params)).interaction().get();
        this.prevInteraction = interaction;

        return interaction;
    }

    public Interaction interact(String prompt) {
        this.prompt = prompt;
        return interact();
    }

    public void archive(String filename) throws IOException {
        String buffer;

        String input = this.prompt;
        String response = this.prevInteraction != null ? this.prevInteraction.outputText().orElse("") : "";

        buffer = String.format("\n\n---\nPrompt:\n%s\n\nResponse:\n%s", input, response);

        System.out.println(buffer);

        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(buffer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Conversation restart(String prompt) {
        return new Conversation(prompt);
    }
}
