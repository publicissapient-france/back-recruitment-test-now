package fr.ps;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.BDDAssertions.then;


class FileUtilsTest {

    //todo: add tests

    /**
     * what if he changes method to static ?
     * what if he use lombok ?
     */
    @Test
    void readFile_should_return_correct_file_content() throws IOException {
        //given
        var path = "src/test/resources/oldApi.csv";
        var utils = new FileUtils();

        //when
        var content = utils.readFile(path);

        //then
        then(content).containsExactly("last_name, first_name, address, city, postal_code, delivery_date, delivery_center",
                "Doe, John,  1234 Boulevard Dupin, Paris ,  75015, 10/03/2022, North",
                "Ann, Mary, 5678 Rue Lafayette, Strasbourg, 67000, 11/03/2022, East",
                "Fabien, Louis, 75 Rue Desnouettes, Bordeaux, 30072, 11/03/2022, Ouest",
                "Kent, Laura, 25 Rue Miromesnil, Paris ,  75009, 10/03/2022, North",
                "Hasna, Mina, 1234 Boulevard Dupin, Paris ,  75015, 10/03/2022, North",
                "");
    }
}
