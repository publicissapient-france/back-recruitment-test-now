package fr.ps.now;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.BDDAssertions.then;


class FileUtilsTest {

    @Test
    void should_return_true_when_file_exists() {
        // Given
        String filePath = "src/test/resources/oldApi.csv";

        // When
        boolean result = FileUtils.fileExists(filePath);

        // Then
        then(result).isTrue();
    }

    @Test
    void readFile_should_return_correct_file_content() {
        //given
        var path = "src/test/resources/oldApi.csv";

        //when
        var content = FileUtils.readFile(path);

        //then
        then(content).containsExactly("last_name, first_name, address, city, postal_code, delivery_date, delivery_center",
                "Doe, John,  1234 Boulevard Dupin, Paris ,  75015, 10/03/2022, North",
                "Ann, Mary, 5678 Rue Lafayette, Strasbourg, 67000, 11/03/2022, East",
                "Fabien, Louis, 75 Rue Desnouettes, Bordeaux, 30072, 11/03/2022, Ouest",
                "Kent, Laura, 25 Rue Miromesnil, Paris ,  75009, 10/03/2022, North",
                "Hasna, Mina, 1234 Boulevard Dupin, Paris ,  75015, 10/03/2022, North",
                "");
    }

    @Test
    void readFile_should_throw_exception_when_file_does_not_exist() {
        //given
        var path = "src/test/resources/notExistingFile.csv";

        //when
        try {
            var content = FileUtils.readFile(path);
        } catch (Exception e) {
            //then
            then(e.getMessage()).isEqualTo("Error while reading file " + path);
        }
    }

    @Test
    void readFile_should_return_empty_list_when_file_is_empty() {
        //given
        var path = "src/test/resources/empty_file.csv";

        //when
        var content = FileUtils.readFile(path);

        //then
        then(content).isEmpty();

    }
}
