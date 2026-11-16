import java.util.Set;
public final class HouseBuilder {

    public static Room build() {
        Entity desk = new Entity("desk", "A small wooden desk with a few scattered notes strewn about and slightly ajar, built-in drawers.",
        "You fiddle with the drawers and find some more notes. 'BEWARE THE CREATURE!' is hastily scribbled on the topmost sheet of graph paper.", false);
        Entity bed = new Entity("bed", "A rather large and impossibly comfy-looking bed. You're quite sleepy, but you cannot rest just yet.", 
        "You walk up to the bed and rest your head. Devilishly comfortable! You'd best get moving before you fall asleep.", false);
        Entity plushie = new Entity("plushie", "A cute little plushie of a... bat? Lizard? Some strange sea creature perhaps?",
        "It's incredibly soft and squishy! Despite being wholly indescipherable as any kind of animal, it's an incredibly endearing toy.", true);
        Entity key = new Entity("key", "A small brass key. Surely this will unlock something, somewhere in this place.",
        "You turn the key over in your fingers. Somehow, it feels ever so slightly too heavy for its size", true);
        PuzzleEntity cabinet = new PuzzleEntity("cabinet", "A small medicine cabinet built into the sink. It looks empty, but the bottom seems a little shaky",
        "You reach into the cabinet and push against the bottom, revealing a false bottom with a key inside!", "There's not much else to see in here", key);
        Entity toilet = new Entity("toilet", "A pristine porcelain throne.", "fwoooooooshhhh........  Flushing an empty toilet's a bit of a waste of water, don't you think?", false);
        Entity sink = new Entity("sink", "A sink with a slightly leaky faucet. You wonder how much this leakage impacts this place's water bill.",
        "You wash your hands with cold water, the chill running from your hands through your body and into your bones.", false);
        Entity mirror = new Entity("mirror", "A mostly clean mirror, with a few specks and smudges from toothpaste and soap here and there",
        "Despite everything, it's still you!", false);
        Entity toiletpaperroll = new Entity("toiletpaper", "A large roll of 1-ply toiler paper. You can tell why the owner of this home gets no guests",
        "You contemplate spinning out the entire roll, stuffing it down the toilet and flushing as many times as you can, but ultimately decide it's not worth the effort", true);
        Entity diningtable = new Entity("diningtable", "A large ash dining table with a genuinely quite gorgeous tablecloth adorning it",
        "You approach the table to take a seat, but immediately stub your toe on one of its legs. You take this as a sign to stay away.", false);
        Entity banana = new Entity("banana", "A bundle of large and very ripe, bright-yellow bananas. You don't really like bananas.",
        "You're completely devoid of appetite, but you suppose they are nice to look at.", true);
        Entity chicken = new Entity("chicken", "An entire rotisserie chicken, sitting on a serving dish with no cover.",
        "It's clearly well seasoned and perfectly cooked, maintaining moisture and flavour throughout. You decide not to eat it... yet...", true);
        PuzzleEntity fridge = new PuzzleEntity("fridge", "A large and seemingly expensive fridge. It has an ice dispenser with 5 different cube sizes!",
        "You open the fridge and find an entire rotisserie chicken! Your lucky day!", "There's not too much else of note in here...", chicken);
        LightSwitchEntity lightswitch = new LightSwitchEntity("lightswitch", "A small rocker lightswitch, presumably for switching the lights.");
        DoorEntity door = new DoorEntity("door", "A locked door. You don't think you can force it open", key);
        Entity creature = new Entity("creature", "Some sort of uncanny amalgam creature, with features mish-mashed and hodge-podged from all kinds of animals is just kind of sitting there.",
        "It's responding to your movements and tilts its 'head' towards you. You get the impression it may like you, if it is indeed capable of such.", true);
        Entity washingmachine = new Entity("washingmachine", "A large and robust looking washing machine. Despite its evident age, it seems more than capable of weathering at least another decade or so.",
        "It seems there's still a load of laundry in there, although the door is stuck shut.", false);
        Entity couch = new Entity("couch", "A fine looking couch, with very soft-looking leather cushions and fashionable throw pillows.",
        "Upon actually sitting down you realise your eyes have deiceved you greatly, and this is maybe the most uncomfortable chair you have ever had the displeasure of sitting in. You quickly get up.", false);
        Entity tv = new Entity("tv", "A large CRT television. This would proabably go for a ton on the vintage resale market.",
        "You turn it on, and shortly following the high-pitched squeal of the screen slowly coming to life, the picture abruptly cuts and the tv shuts off. What a shame.", false);
        Entity lamp = new Entity("lamp", "A kind of ugly standing lamp that clashes quite terribly with the rest of the room. Who picked this out?",
        "You pull on the chain but the light doesn't switch on. Fortunely for you, this room gets plenty of natural light.", false);
        Entity rug = new Entity("rug", "A shaggy burgundy and orange rug. This could look pretty interesting in any home other than this one.",
        "On closer inspection, the rug has very intricate details woven into it pattern. You're almost jealous...", true);
        Entity houseplant = new Entity("houseplant", "A plant of some kind, though you don't know too much about plants so which kind in particular you can only guess",
        "Its leaves are quita a vibrant green despite its soil looking quite dry. You'd water it but, given your ignorance about plants you might just drown it on accident.", true);

        Room bathroom = new OpenRoom(Set.of(sink, toilet, mirror, cabinet, toiletpaperroll), "bathroom", "A nice white-tile-lined bathroom with toiletries strewn about. The entrance is to the south.");
        Room kitchen = new OpenRoom(Set.of(sink, diningtable, fridge, banana), "kitchen", "A rather mundane little kitchen, not very well stocked for cooking. The door you came in from is to the east.");
        DarkRoom basement = new DarkRoom(Set.of(lightswitch, creature, washingmachine), "basement", "Despite it still being quite dark, you notice IT almost immediately.", lightswitch);
        LockedRoom bedroom = new LockedRoom(Set.of(bed, desk, plushie), "bedroom", "A nice little bedroom with a comfortable looking bed with a strange plushie on it.", door);
        Room foyer = new OpenRoom(Set.of(couch, rug, houseplant, lamp, tv), "foyer", "An interesting foyer with very strange furniture choices. There are doors to the north and west, as well as stairs leading up and down.");

        foyer.connect(Direction.NORTH, bathroom);
        foyer.connect(Direction.WEST, kitchen);
        foyer.connect(Direction.UP, bedroom);
        foyer.connect(Direction.DOWN, basement);

        return foyer;
    }
}