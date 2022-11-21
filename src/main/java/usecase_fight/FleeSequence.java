package usecase_fight;

public class FleeSequence {
    public void flee(){
        // does not change player state
        // calculate flee success
        // if successful, call presenter, choose a random flee success message
        // if not successful, inflict flee damage and call presenter, choose random flee fail message
    }

    // flee strings:
    // You got away safely!
    // Not a scratch on you!
    // You're safe!
    // perhaps you should have brought running shoes

    // scratch strings. The <monster> hit you as you ran away! Lost <num> health.
    // You barely got away! Lost <num> health.
    // If only you ran a bit faster! Lost <num> health
    // That was a close one! Lost <num> health
}
