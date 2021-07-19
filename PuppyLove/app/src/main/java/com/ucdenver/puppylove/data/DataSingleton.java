package com.ucdenver.puppylove.data;

public final class DataSingleton {
    static public DataManager instance;

    static public void SetInstance(DataManager _instance) {
        instance = _instance;
        insertDogs();
    }

    static private void insertDogs() {
        Interactor.getDogInstance().insert(
                "Kuma",
                2,
                "Shiba Inu",
                "BUY DOGE",
                "shiba_inu"
        );
        Interactor.getDogInstance().insert(
                "Leo",
                4,
                "German Shepherd",
                "Friendly german shepherd!",
                "german_shepherd"
        );
        Interactor.getDogInstance().insert(
                "Daisy",
                3,
                "Australian Shepherd",
                "Energetic Australian shepherd!",
                "australian_shepherd"
        );
        Interactor.getDogInstance().insert(
                "Toki",
                2,
                "Akita Inu",
                "Cute akita inu!",
                "akita_inu"
        );
        Interactor.getDogInstance().insert(
                "Dory",
                2,
                "Westie",
                "Smart westie!",
                "westie"
        );
        Interactor.getDogInstance().insert(
                "Max",
                3,
                "Golden Retriever",
                "Loyal golden retriever!",
                "golden_retriever"
        );
        Interactor.getDogInstance().insert(
                "Maverick",
                1,
                "Corgi",
                "Troublesome",
                "corgi"
        );
        Interactor.getDogInstance().insert(
                "Stella",
                1,
                "Black labrador",
                "So cute",
                "black_labrador"
        );
        Interactor.getDogInstance().insert(
                "Lucy",
                5,
                "Bernese Mountain Dog",
                "So fluffy!",
                "bernese_mountain_dog"
        );
    }
}
