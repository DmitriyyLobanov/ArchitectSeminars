using PetClinicService.Models;
using PetClinicService.Services;

namespace PetClinicService.Services
{
    public interface IClientRepository : IRepository<Client, int>
    {
    }
}
