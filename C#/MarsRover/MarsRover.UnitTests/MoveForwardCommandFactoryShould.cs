using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    internal class MoveForwardCommandFactoryShould
    {
        [Test]
        public void CreateMoveNorthCommandWhenOrientationIsN()
        {
            var actualCommand = MoveForwardCommandFactory.Create(Orientation.N);

            actualCommand.Should().BeOfType<MoveNorthCommand>();
        }

        [Test]
        public void CreateMoveEastCommandWhenOrientationIsE()
        {
            var actualCommand = MoveForwardCommandFactory.Create(Orientation.E);

            actualCommand.Should().BeOfType<MoveEastCommand>();
        }

        [Test]
        public void CreateMoveSouthCommandWhenOrientationIsS()
        {
            var actualCommand = MoveForwardCommandFactory.Create(Orientation.S);

            actualCommand.Should().BeOfType<MoveSouthCommand>();
        }

        [Test]
        public void CreateMoveWestCommandWhenOrientationIsW()
        {
            var actualCommand = MoveForwardCommandFactory.Create(Orientation.W);

            actualCommand.Should().BeOfType<MoveWestCommand>();
        }
    }
}
