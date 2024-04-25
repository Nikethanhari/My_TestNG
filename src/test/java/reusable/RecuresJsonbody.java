package reusable;

public class RecuresJsonbody {


    public String CreateUserJsonBody(String username, String ssno) {

        String response_body = "{\n" +
                "    \"name\": \"" + username + "\",\n" +
                "    \"job\": \"API TEST AUTOMATION LEAD\",\n" +
                "    \"Address\": \"123 Dublin Blvd USA\",\n" +
                "    \"SSN\": \"" + ssno + "\"\n" +
                "}";
        return response_body;
    }

    public String user_create_the_conversion_request_body(String cles) {
        String request_body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "    <soap12:Body>\n" +
                "        <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                "            <Celsius>" + cles + "</Celsius>\n" +
                "        </CelsiusToFahrenheit>\n" +
                "    </soap12:Body>\n" +
                "</soap12:Envelope>";

        return request_body;
    }

}
