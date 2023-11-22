package com.mygdx.game.Profile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap;

import java.util.Enumeration;
import java.util.Hashtable;

public class ProfileManager extends ProfileSubject {

    private Json json; // Objeto para serialização/desserialização JSON
    private static ProfileManager profileManager; // Instância única do ProfileManager
    private Hashtable<String, FileHandle> profiles; // Mapa de perfis e seus arquivos
    private ObjectMap<String, Object> profileProperties = new ObjectMap<>(); // Propriedades do perfil atual
    private String profileName; // Nome do perfil atual
    private boolean isNewProfile = false; // Sinalizador para indicar se é um novo perfil

    private static final String SAVEGAME_SUFFIX = ".sav"; // Sufixo para arquivos de perfil
    public static final String DEFAULT_PROFILE = "default"; // Nome padrão para o perfil

    // Construtor
    public ProfileManager() {
        json = new Json();
        profiles = new Hashtable<>();
        profiles.clear();
        profileName = DEFAULT_PROFILE;
        storeAllProfiles(); // Carrega todos os perfis existentes
    }

    // Obtém a instância única do ProfileManager
    public static ProfileManager getInstance() {
        if (profileManager == null) {
            profileManager = new ProfileManager();
        }
        return profileManager;
    }

    // Define se é um novo perfil
    public void setIsNewProfile(boolean isNewProfile) {
        this.isNewProfile = isNewProfile;
    }

    // Obtém se é um novo perfil
    public boolean getIsNewProfile() {
        return this.isNewProfile;
    }

    // Obtém uma lista de todos os perfis existentes
    public Array<String> getProfileList() {
        Array<String> profiles = new Array<>();
        for (Enumeration<String> e = this.profiles.keys(); e.hasMoreElements(); ) {
            profiles.add(e.nextElement());
        }
        return profiles;
    }

    // Obtém o arquivo associado a um perfil
    public FileHandle getProfileFile(String profile) {
        if (!doesProfileExist(profile)) {
            return null;
        }
        return profiles.get(profile);
    }

    // Armazena todos os perfis disponíveis
    public void storeAllProfiles() {
        if (Gdx.files.isLocalStorageAvailable()) {
            FileHandle[] files = Gdx.files.local(".").list(SAVEGAME_SUFFIX);

            for (FileHandle file : files) {
                profiles.put(file.nameWithoutExtension(), file);
            }
        } else {
            // TODO: Tente o diretório externo aqui
            return;
        }
    }

    // Verifica se um perfil existe
    public boolean doesProfileExist(String profileName) {
        return profiles.containsKey(profileName);
    }

    // Escreve o perfil no armazenamento
    public void writeProfileToStorage(String profileName, String fileData, boolean overwrite) {
        String fullFilename = profileName + SAVEGAME_SUFFIX;

        boolean localFileExists = Gdx.files.local(fullFilename).exists();

        // Se não pode sobrescrever e o arquivo existe, saia
        if (localFileExists && !overwrite) {
            return;
        }

        FileHandle file = null;

        if (Gdx.files.isLocalStorageAvailable()) {
            file = Gdx.files.local(fullFilename);
            String encodedString = Base64Coder.encodeString(fileData);
            file.writeString(encodedString, !overwrite);
        }

        profiles.put(profileName, file);
    }

    // Define uma propriedade no perfil
    public void setProperty(String key, Object object) {
        profileProperties.put(key, object);
    }

    // Obtém uma propriedade do perfil
    public <T extends Object> T getProperty(String key, Class<T> type) {
        T property = null;
        if (!profileProperties.containsKey(key)) {
            return property;
        }
        property = (T) profileProperties.get(key);
        return property;
    }

    // Salva o perfil no armazenamento
    public void saveProfile() {
        notify(this, ProfileObserver.ProfileEvent.SAVING_PROFILE);
        String text = json.prettyPrint(json.toJson(profileProperties));
        writeProfileToStorage(profileName, text, true);
    }

//    /**
//     * Carrega o perfil do armazenamento.
//     * Se for um novo perfil, notifica a remoção do perfil atual e salva o perfil.
//     */
//    public void loadProfile() {
//        // Se for um novo perfil, notifica a remoção do perfil atual e salva o perfil
//        if (isNewProfile) {
//            // Notifica a remoção do perfil atual
//            notify(this, ProfileObserver.ProfileEvent.CLEAR_CURRENT_PROFILE);
//            // Salva o perfil
//            saveProfile();
//        }
//
//        // Obtém o nome completo do arquivo de perfil
//        String fullProfileFileName = profileName + SAVEGAME_SUFFIX;
//        // Verifica se o arquivo de perfil existe
//        boolean doesProfileFileExist = Gdx.files.local(fullProfileFileName).exists();
//
//        // Se o arquivo de perfil não existir, retorna
//        if (!doesProfileFileExist) {
//            return;
//        }
//
//        // Obtém o arquivo de perfil codificado
//        FileHandle encodedFile = profiles.get(profileName);
//        // Lê o conteúdo do arquivo
//        String s = encodedFile.readString();
//
//        // Decodifica o conteúdo do arquivo usando Base64
//        String decodedFile = Base64Coder.decodeString(s);
//
//        // Converte o conteúdo decodificado para um ObjectMap usando JSON
//        profileProperties = json.fromJson(ObjectMap.class, decodedFile);
//
//        // Notifica que o perfil foi carregado
//        notify(this, ProfileObserver.ProfileEvent.PROFILE_LOADED);
//
//        // Define que não é mais um novo perfil
//        isNewProfile = false;
//    }


    // Define o perfil atual
    public void setCurrentProfile(String profileName) {
        if (doesProfileExist(profileName)) {
            this.profileName = profileName;
        } else {
            this.profileName = DEFAULT_PROFILE;
        }
    }
}
