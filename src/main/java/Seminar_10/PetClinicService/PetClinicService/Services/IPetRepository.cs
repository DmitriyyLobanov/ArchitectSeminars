using PetClinicService.Models;
using PetClinicService.Services;

namespace PetClinicService.Services
{
    public interface IPetRepository : IRepository<Pet, int> 
    {
    }
}
