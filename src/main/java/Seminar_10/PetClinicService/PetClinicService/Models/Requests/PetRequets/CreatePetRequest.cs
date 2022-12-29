namespace PetClinicService.Models.Requests.PetRequets
{
    public class CreatePetRequest
    {
        public int ClientId { get; set; }
        public string Name { get; set; }
        public DateTime BirthDay { get; set; }
    }
}
